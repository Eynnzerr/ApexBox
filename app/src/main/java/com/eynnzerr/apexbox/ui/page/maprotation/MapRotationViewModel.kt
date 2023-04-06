package com.eynnzerr.apexbox.ui.page.maprotation

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eynnzerr.apexbox.base.CPApplication
import com.eynnzerr.apexbox.data.model.bean.MapRotation
import com.eynnzerr.apexbox.data.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import com.eynnzerr.apexbox.R
import com.eynnzerr.apexbox.data.preference.MMKVAgent
import com.eynnzerr.apexbox.data.preference.PreferenceKeys
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext

data class MapUiState(
    val mapRotation: MapRotation = MapRotation(),
    val success: Int = -3,
    val commonCountDownTime: String = "00:00:00",
    val rankCountDownTime: String = "00:00:00",
    val mixTapeCountDownTime: String = "00:00:00",
    val openSubscriptionDialog: Boolean = false,
    val mapSelections: MutableList<Boolean> = mutableListOf()
)

@HiltViewModel
class MapRotationViewModel @Inject constructor(
    private val repository: AppRepository
): ViewModel() {
    private val _mapUiState = MutableStateFlow(MapUiState(mapSelections = loadMapSubscriptions()))
    val mapUiState = _mapUiState.asStateFlow()

    init {
        fetchMapRotation()
    }

    fun updateMapSubscriptions(index: Int, selected: Boolean) {
        _mapUiState.value.mapSelections[index] = selected
        var subscriptionNumber = MMKVAgent.decodeInt(PreferenceKeys.MAP_SUBSCRIPTION, 0)
        val bit = 1 shl index
        if (selected) {
            subscriptionNumber = subscriptionNumber or bit
        } else {
            subscriptionNumber = subscriptionNumber and bit.inv()
        }
        MMKVAgent.encodeInt(PreferenceKeys.MAP_SUBSCRIPTION, subscriptionNumber)
    }

    private fun loadMapSubscriptions(): MutableList<Boolean> {
        val subscriptionNumber = MMKVAgent.decodeInt(PreferenceKeys.MAP_SUBSCRIPTION, 0)
        val mapSelections = mutableListOf<Boolean>()
        var bit = 1
        repeat(5) {
            mapSelections.add(subscriptionNumber and bit != 0)
            bit = bit shl 1
        }
        return mapSelections
    }

    fun updateDialogState() = _mapUiState.update { it.copy(openSubscriptionDialog = !it.openSubscriptionDialog) }

    fun updateMapRotation() = updateMapRotation { mapRotation ->
        _mapUiState.update { it.copy(mapRotation = mapRotation, success = 0) }
    }

    fun fetchMapRotation() = updateMapRotation { mapRotation ->
        _mapUiState.update { it.copy(mapRotation = mapRotation, success = 0) }

        viewModelScope.launch(Dispatchers.IO) {
            // BR mode
            textCountDownTimerFlow(
                mapRotation.battle_royale.current.remainingSecs,
                onTick = { date -> _mapUiState.update { it.copy(commonCountDownTime = date) } },
                onCompletion = { updateBRMap() }
            )
        }

        viewModelScope.launch(Dispatchers.IO) {
            // Rank mode
            textCountDownTimerFlow(
                mapRotation.ranked.current.remainingSecs,
                onTick = { date -> _mapUiState.update { it.copy(rankCountDownTime = date) } },
                onCompletion = { updateRankMap() }
            )
        }

        viewModelScope.launch(Dispatchers.IO) {
            // mix tape mode
            textCountDownTimerFlow(
                mapRotation.ltm.current.remainingSecs,
                onTick = { date -> _mapUiState.update { it.copy(mixTapeCountDownTime = date) } },
                onCompletion = { updateMixTapeMap() }
            )
        }
    }

    // only update map of battle royale mode and set timer flow.
    private fun updateBRMap() {
        updateMapRotation { mapRotation ->
            _mapUiState.update { it.copy(mapRotation = it.mapRotation.copy(battle_royale = mapRotation.battle_royale)) }
            viewModelScope.launch {
                textCountDownTimerFlow(
                    mapRotation.battle_royale.current.remainingSecs,
                    onTick = { date -> _mapUiState.update { it.copy(commonCountDownTime = date) } },
                    onCompletion = { updateBRMap() }
                )
            }
        }
    }

    // only update map of rank mode and set timer flow.
    private fun updateRankMap() {
        updateMapRotation { mapRotation ->
            _mapUiState.update { it.copy(mapRotation = it.mapRotation.copy(ranked = mapRotation.ranked)) }
            viewModelScope.launch {
                textCountDownTimerFlow(
                    mapRotation.ranked.current.remainingSecs,
                    onTick = { date -> _mapUiState.update { it.copy(rankCountDownTime = date) } },
                    onCompletion = { updateRankMap() }
                )
            }
        }
    }

    // only update map of mix tape mode and set timer flow.
    private fun updateMixTapeMap() {
        updateMapRotation { mapRotation ->
            _mapUiState.update { it.copy(mapRotation = it.mapRotation.copy(ltm = mapRotation.ltm)) }
            viewModelScope.launch {
                textCountDownTimerFlow(
                    mapRotation.ltm.current.remainingSecs,
                    onTick = { date -> _mapUiState.update { it.copy(mixTapeCountDownTime = date) } },
                    onCompletion = { updateMixTapeMap() }
                )
            }
        }
    }

    private suspend fun textCountDownTimerFlow(totalSecs: Int, onTick: (String) -> Unit, onCompletion: () -> Unit) {
        flow {
            for (sec in totalSecs downTo 0) {
                emit(sec)
                delay(1000)
            }
        }.onCompletion {
            onCompletion()
        }.map {
            // map seconds to hh:mm:ss
            val hours = it / 3600
            val minutes = (it % 3600) / 60
            val seconds = it % 60
            String.format("%02d:%02d:%02d", hours, minutes, seconds)
        }.collect { date ->
            // update counter
            onTick(date)
        }
    }

    private fun updateMapRotation(onNewRotation: (MapRotation) -> Unit) {
        _mapUiState.update { it.copy(success = -3) }  // Relaunch progress indicator.
        viewModelScope.launch(Dispatchers.IO) {
            runCatching{
                repository.getMapRotation()
            }.onSuccess { response ->
                Log.d(TAG, "fetchMapRotation: $response")
                if (response.isSuccessful) {
                    response.body()?.let { mapRotation ->
                        onNewRotation(mapRotation)
                        withContext(Dispatchers.Main) {
                            Toast.makeText(CPApplication.context, CPApplication.context.resources.getText(R.string.toast_refreshed), Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }.onFailure { exception ->
                Log.d(TAG, "fetchMapRotation: $exception")
                when (exception) {
                    is HttpException -> {
                        // unexpected response
                        _mapUiState.update { it.copy(mapRotation = MapRotation(), success = -1) }
                        withContext(Dispatchers.Main) {
                            Toast.makeText(CPApplication.context, CPApplication.context.resources.getText(R.string.toast_error), Toast.LENGTH_SHORT).show()
                        }
                    }
                    is IOException -> {
                        // No internet
                        _mapUiState.update { it.copy(mapRotation = MapRotation(), success = -2) }
                        withContext(Dispatchers.Main) {
                            Toast.makeText(CPApplication.context, CPApplication.context.resources.getText(R.string.toast_lost_internet), Toast.LENGTH_SHORT).show()
                        }
                    }
                    else -> {
                        _mapUiState.update { it.copy(mapRotation = MapRotation(), success = -3) }
                        withContext(Dispatchers.Main) {
                            Toast.makeText(CPApplication.context, CPApplication.context.resources.getText(R.string.toast_other), Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}

private const val TAG = "MapRotationViewModel"
package com.eynnzerr.apexbox.ui.page.player

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eynnzerr.apexbox.R
import com.eynnzerr.apexbox.base.CPApplication
import com.eynnzerr.apexbox.data.model.bean.PlayerStats
import com.eynnzerr.apexbox.data.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

data class PlayerUiState(
    val playerName: String = "",
    val platform: String = "PC",
    val playerNotExist: Boolean = false,
    val stats: PlayerStats = PlayerStats(),
    val statsReady: Boolean = false,
    val statsPreparing: Boolean = false
)

@HiltViewModel
class PlayerViewModel @Inject constructor(
    private val repository: AppRepository
): ViewModel() {
    private val _playerUiState = MutableStateFlow(PlayerUiState())
    val playerUiState = _playerUiState.asStateFlow()

    fun clearState() = _playerUiState.update { PlayerUiState() }

    fun updateInputName(name: String) = _playerUiState.update { it.copy(playerName = name) }

    fun updatePlatform(platform: String) = _playerUiState.update { it.copy(platform = platform) }

    fun fetchPlayerStats() {
        _playerUiState.update { it.copy(statsPreparing = true) }
        viewModelScope.launch(Dispatchers.IO) {
            runCatching{
                repository.getPlayerStats(_playerUiState.value.playerName, _playerUiState.value.platform)
            }.onSuccess { response ->
                Log.d(TAG, "fetchNewCrafts: $response")
                _playerUiState.update { it.copy(playerNotExist = false) }
                if (response.isSuccessful) {
                    response.body()?.let { playerStats ->
                        Log.d(TAG, "fetchPlayerStats: $playerStats")
                        _playerUiState.update { it.copy(stats = playerStats, statsReady = true, statsPreparing = false) }
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                CPApplication.context, CPApplication.context.resources.getText(
                                    R.string.toast_loaded), Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }.onFailure { exception ->
                _playerUiState.update { it.copy(playerNotExist = true, statsReady = false, statsPreparing = false) }
                when (exception) {
                    is HttpException -> {
                        // unexpected response
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                CPApplication.context, CPApplication.context.resources.getText(
                                    R.string.toast_error), Toast.LENGTH_SHORT).show()
                        }
                    }
                    is IOException -> {
                        // No internet
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                CPApplication.context, CPApplication.context.resources.getText(
                                    R.string.toast_lost_internet), Toast.LENGTH_SHORT).show()
                        }
                    }
                    else -> {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                CPApplication.context, CPApplication.context.resources.getText(
                                    R.string.toast_other), Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}

private const val TAG = "PlayerViewModel"
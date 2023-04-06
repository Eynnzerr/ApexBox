package com.eynnzerr.apexbox.ui.page.craft

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eynnzerr.apexbox.R
import com.eynnzerr.apexbox.base.CPApplication
import com.eynnzerr.apexbox.data.model.bean.CraftItem
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

data class CraftUiState(
    val craftList: List<CraftItem> = emptyList()
)

@HiltViewModel
class CraftListViewModel @Inject constructor(
    private val repository: AppRepository
): ViewModel() {
    private val _craftUiState = MutableStateFlow(CraftUiState())
    val craftUiState = _craftUiState.asStateFlow()

    init {
        if (_craftUiState.value.craftList.isEmpty()) {
            fetchNewCrafts()
        }
    }

    fun fetchNewCrafts() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching{
                repository.getCraftList()
            }.onSuccess { response ->
                Log.d(TAG, "fetchNewCrafts: $response")
                if (response.isSuccessful) {
                    response.body()?.let { craftList ->
                        _craftUiState.update { it.copy(craftList = craftList) }
                    }
                }
            }.onFailure { exception ->
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

private const val TAG = "CraftListViewModel"
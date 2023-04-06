package com.eynnzerr.apexbox.ui.page.news

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eynnzerr.apexbox.R
import com.eynnzerr.apexbox.base.CPApplication
import com.eynnzerr.apexbox.data.model.bean.ApexNews
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

data class NewsUiState(
    val news: List<ApexNews> = emptyList()
)

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: AppRepository,
): ViewModel() {
    private val _newsUiState = MutableStateFlow(NewsUiState())
    val newsUiState = _newsUiState.asStateFlow()

    init {
        // fetchNews()
        getCachedNews()
    }

    fun getCachedNews() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCachedNewsFlow().collect { cachedNewsList ->
                if (cachedNewsList.isEmpty()) {
                    fetchNews()
                }
                _newsUiState.update { it.copy(news = cachedNewsList) }
            }
        }
    }

    fun fetchNews() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching{
                repository.getNews()
            }.onSuccess { response ->
                Log.d(TAG, "fetchNewCrafts: $response")
                if (response.isSuccessful) {
                    response.body()?.let { craftList ->
                        repository.insertNews(*craftList.toTypedArray())
                        withContext(Dispatchers.Main) {
                            Toast.makeText(CPApplication.context, CPApplication.context.resources.getText(R.string.news_toast_refreshed), Toast.LENGTH_SHORT).show()
                        }
                        // _newsUiState.update { it.copy(craftList) }
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

private const val TAG = "NewsViewModel"
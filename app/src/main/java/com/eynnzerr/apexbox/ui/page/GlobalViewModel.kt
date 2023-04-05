package com.eynnzerr.apexbox.ui.page

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class GlobalViewModel @Inject constructor(): ViewModel() {
    private val _navigationIndexState = MutableStateFlow(0)
    val navigationIndexState = _navigationIndexState.asStateFlow()

    fun updateNavigationIndex(index: Int) = _navigationIndexState.update { index }
}
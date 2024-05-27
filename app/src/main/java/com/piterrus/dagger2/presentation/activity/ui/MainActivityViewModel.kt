package com.piterrus.dagger2.presentation.activity.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.piterrus.dagger2.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val activityUseCase: UseCase,
    private val coroutineDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val activityMutableState = MutableStateFlow("")
    val activityState = activityMutableState.asStateFlow()

    fun getString() {
        viewModelScope.launch(coroutineDispatcher) {
            activityMutableState.update {
                activityUseCase.getString()
            }
        }
    }
}
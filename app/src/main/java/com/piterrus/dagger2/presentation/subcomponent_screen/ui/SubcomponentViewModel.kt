package com.piterrus.dagger2.presentation.subcomponent_screen.ui

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.piterrus.dagger2.R
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@SuppressLint("StaticFieldLeak") //compilation warning (context provides like an appContext, not like activity context)
class SubcomponentViewModel(
    private val coroutineDispatcher: CoroutineDispatcher,
     private val context: Context
) : ViewModel() {

    private val mutableState = MutableStateFlow(SubcomponentState())
    val state = mutableState.asStateFlow()

    fun getResultOfSomeLongOperation() {
        viewModelScope.launch(coroutineDispatcher) {
            mutableState.update { it.copy(isLoading = true) }
            delay(2000)
            mutableState.update {
                it.copy(
                    isLoading = false,
                    stringForDisplaying = context.getString(R.string.subcomponent_string)
                )
            }
        }
    }

}
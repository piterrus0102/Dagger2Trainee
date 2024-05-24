package com.piterrus.dagger2.presentation.activity

sealed class MainActivityIntent {

    data object OnProvidesClick : MainActivityIntent()

    data object OnBindsClick : MainActivityIntent()

    data object OnIntoSetAndIntoMapClick : MainActivityIntent()

    data object OnInjectMethodClick : MainActivityIntent()

    data object OnBuilderClick : MainActivityIntent()

    data object OnBindsInstanceClick : MainActivityIntent()
}
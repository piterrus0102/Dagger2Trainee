package com.piterrus.dagger2.presentation.activity.ui

sealed class MainActivityIntent {

    data object OnProvidesClick : MainActivityIntent()

    data object OnBindsClick : MainActivityIntent()

    data object OnIntoSetAndIntoMapClick : MainActivityIntent()

    data object OnInjectMethodClick : MainActivityIntent()

    data object OnBuilderAndFactoryClick : MainActivityIntent()

    data object OnBindsInstanceClick : MainActivityIntent()

    data object OnSubcomponentClick : MainActivityIntent()
}
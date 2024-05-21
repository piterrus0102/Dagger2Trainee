package com.piterrus.dagger2.presentation.activity

sealed class MainActivityIntent {

    data object OnProvidesClick : MainActivityIntent()

    data object OnBindsClick : MainActivityIntent()
}
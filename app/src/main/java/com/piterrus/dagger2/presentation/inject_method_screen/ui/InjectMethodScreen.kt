package com.piterrus.dagger2.presentation.inject_method_screen.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import com.piterrus.dagger2.App
import com.piterrus.dagger2.domain.into_set_and_into_map.Logger
import com.piterrus.dagger2.domain.into_set_and_into_map.Printer
import com.piterrus.dagger2.presentation.inject_method_screen.di.DaggerInjectMethodComponent
import com.piterrus.dagger2.presentation.into_set_and_into_map_screen.di.DaggerIntoSetAndIntoMapComponent
import kotlinx.coroutines.delay

@Composable
fun InjectMethodScreen() {

    val component = remember {
        DaggerInjectMethodComponent.builder()
            .appComponent(App.appComponent)
            .build()
    }

    component.getClassWithInjectedMethod()

}
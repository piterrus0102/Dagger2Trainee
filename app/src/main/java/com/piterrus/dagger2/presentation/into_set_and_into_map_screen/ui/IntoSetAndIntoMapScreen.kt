package com.piterrus.dagger2.presentation.into_set_and_into_map_screen.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import com.piterrus.dagger2.App
import com.piterrus.dagger2.domain.into_set_and_into_map.Logger
import com.piterrus.dagger2.domain.into_set_and_into_map.Printer
import com.piterrus.dagger2.presentation.into_set_and_into_map_screen.di.DaggerIntoSetAndIntoMapComponent
import kotlinx.coroutines.delay

@Composable
fun IntoSetAndIntoMapScreen() {

    val component = remember {
        DaggerIntoSetAndIntoMapComponent.builder()
            .appComponent(App.appComponent)
            .build()
    }

    val printersAndLoggersSet = remember { component.getPrintersAndLoggersSet() }
    val printersAndLoggersMap = remember { component.getPrintersAndLoggersMap() }
    LaunchedEffect(key1 = true) {
        printersAndLoggersSet.forEach { it.print("Dagger2 @IntoSet working") }
        delay(2000)
        printersAndLoggersMap[Printer.KEY]?.print("Dagger2 @IntoMap working printer")
        printersAndLoggersMap[Logger.KEY]?.print("Dagger2 @IntoMap working logger")
    }

}
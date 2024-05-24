package com.piterrus.dagger2.presentation.builder_screen.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.piterrus.dagger2.App
import com.piterrus.dagger2.di.modules.builder.BuilderModule
import com.piterrus.dagger2.presentation.builder_screen.di.DaggerBuilderComponent

@Composable
fun BuilderScreen() {

    val component = remember {
        DaggerBuilderComponent.builder()
            .appComponent(App.appComponent)
            .builderModule(BuilderModule(stringWhichSetValueDuringBuilding = "qwerty"))
            .buildBuilderComponent()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = component.getStringWhichSetValueDuringBuilding(),
            style = MaterialTheme.typography.headlineSmall,
            color = Color.Black
        )
    }
}
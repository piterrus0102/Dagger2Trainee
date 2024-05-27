package com.piterrus.dagger2.presentation.builder_and_factory_screen.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.piterrus.dagger2.App
import com.piterrus.dagger2.R
import com.piterrus.dagger2.di.modules.builder_and_factory.BuilderAndFactoryModule
import com.piterrus.dagger2.presentation.builder_and_factory_screen.di.DaggerBuilderComponent
import com.piterrus.dagger2.presentation.builder_and_factory_screen.di.DaggerFactoryComponent

@Composable
fun BuilderAndFactoryScreen() {

    val component = remember {
        DaggerBuilderComponent.builder()
            .appComponent(App.appComponent)
            .builderModule(BuilderAndFactoryModule(stringWhichSetValueDuringBuilding = "Builder string"))
            .buildBuilderComponent()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(id = R.string.text_from_builder))

        Text(
            text = component.getStringWhichSetValueDuringBuilding(),
            style = MaterialTheme.typography.headlineSmall,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))
        FirstScreenWithFactoryComponent()

        Spacer(modifier = Modifier.height(8.dp))
        SecondScreenWithFactoryComponent()
    }
}

@Composable
private fun FirstScreenWithFactoryComponent() {
    val component = remember {
        DaggerFactoryComponent
            .factory()
            .create(
                appComponent = App.appComponent,
                builderAndFactoryModule = BuilderAndFactoryModule(stringWhichSetValueDuringBuilding = "First Factory String")
            )
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(id = R.string.text_from_factory_first))

        Text(
            text = component.getStringWhichSetValueDuringBuilding(),
            style = MaterialTheme.typography.headlineSmall,
            color = Color.Black
        )
    }
}

@Composable
private fun SecondScreenWithFactoryComponent() {
    val component = remember {
        DaggerFactoryComponent
            .factory()
            .create(
                appComponent = App.appComponent,
                builderAndFactoryModule = BuilderAndFactoryModule(stringWhichSetValueDuringBuilding = "Second Factory String")
            )
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(id = R.string.text_from_factory_second))

        Text(
            text = component.getStringWhichSetValueDuringBuilding(),
            style = MaterialTheme.typography.headlineSmall,
            color = Color.Black
        )
    }
}
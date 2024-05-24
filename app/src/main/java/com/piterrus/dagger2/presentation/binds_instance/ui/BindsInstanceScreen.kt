package com.piterrus.dagger2.presentation.binds_instance.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.piterrus.dagger2.App
import com.piterrus.dagger2.di.modules.builder.BuilderModule
import com.piterrus.dagger2.presentation.binds_instance.di.DaggerBindsInstanceComponent
import com.piterrus.dagger2.presentation.builder_screen.di.DaggerBuilderComponent
import dagger.BindsInstance


@Composable
fun BindsInstanceScreen() {
    val component = remember {
        DaggerBindsInstanceComponent.builder()
            .appComponent(App.appComponent)
            .string(string = "bindsInstanceString")
            .buildBindsInstanceComponent()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = component.stringByBindsInstance(),
            style = MaterialTheme.typography.headlineSmall,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = component.stringByModule(),
            style = MaterialTheme.typography.headlineSmall,
            color = Color.Black
        )
    }
}
package com.piterrus.dagger2.presentation.binds_screen.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.piterrus.dagger2.App
import com.piterrus.dagger2.R
import com.piterrus.dagger2.presentation.activity.MainActivityViewModel
import com.piterrus.dagger2.presentation.binds_screen.di.DaggerBindsScreenComponent
import com.piterrus.dagger2.compose.theme.Dagger2TraineeTheme

@Composable
fun BindsScreen() {
    val component = remember {
        DaggerBindsScreenComponent.builder()
            .appComponent(App.appComponent)
            .build()
    }

    val viewModel: MainActivityViewModel = if (com.piterrus.dagger2.BuildConfig.type == "first") {
        remember { component.getFirstActivityViewModel() }
    } else {
        remember { component.getSecondActivityViewModel() }
    }
    LaunchedEffect(key1 = true) {
        viewModel.getString()
    }
    val string = viewModel.activityState.collectAsState().value

    var click by remember { mutableStateOf(false) }
    val computableText = if (click) {
        component.lazyStringFromDagger().get()
    } else {
        stringResource(id = R.string.button_text)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Greeting(string)
        Button(
            onClick = {
                click = !click
            },
            content = {
                Text(
                    text = computableText
                )
            }
        )
    }
}

@Composable
private fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun BindsScreen_Preview() {
    Dagger2TraineeTheme {
        BindsScreen()
    }
}
package com.piterrus.dagger2.presentation.first_screen.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.piterrus.dagger2.App.Companion.appComponent
import com.piterrus.dagger2.R
import com.piterrus.dagger2.domain.into_set_and_into_map.Logger
import com.piterrus.dagger2.domain.into_set_and_into_map.Printer
import com.piterrus.dagger2.presentation.first_screen.di.DaggerFirstScreenComponent
import com.piterrus.dagger2.ui.theme.Dagger2TraineeTheme
import kotlinx.coroutines.delay

@Composable
fun FirstScreen(
    text: String
) {
    val component = remember {
        DaggerFirstScreenComponent.builder()
            .appComponent(appComponent)
            .build()
    }

    val printersAndLoggersSet = remember { component.getPrintersAndLoggersSet() }
    val printersAndLoggersMap = remember { component.getPrintersAndLoggersMap() }
    LaunchedEffect(key1 = true) {
        printersAndLoggersSet.forEach { it.print("Dagger2 @IntoSet working") }
        delay(2000)
        printersAndLoggersMap[Printer.KEY]?.print("Dagger2 @IntoMap working printer")
        printersAndLoggersMap[Logger.KEY]?.print("Dagger2 @IntoMap working logger")
        component.getClassWithInjectedMethod().checkWorkingPostInit()
    }

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
        Greeting(text)
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
fun Greeting(name: String, modifier: Modifier = Modifier) {
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
fun GreetingPreview() {
    Dagger2TraineeTheme {
        FirstScreen(text = "Android")
    }
}
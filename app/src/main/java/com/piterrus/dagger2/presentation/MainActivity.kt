package com.piterrus.dagger2.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.multidex.BuildConfig
import com.piterrus.dagger2.App
import com.piterrus.dagger2.di.activity.DaggerActivityComponent
import com.piterrus.dagger2.ui.theme.Dagger2TraineeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val activityComponent = remember {
                DaggerActivityComponent.builder()
                    .appComponent(App.appComponent)
                    .build()
            }
            val viewModel: ActivityViewModel
            if (com.piterrus.dagger2.BuildConfig.type == "first") {
                viewModel = remember { activityComponent.getFirstActivityViewModel() }
            } else {
                viewModel = remember { activityComponent.getSecondActivityViewModel() }
            }

            val string = viewModel.activityState.collectAsState()
            viewModel.getString()
            Dagger2TraineeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(string.value)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Dagger2TraineeTheme {
        Greeting("Android")
    }
}
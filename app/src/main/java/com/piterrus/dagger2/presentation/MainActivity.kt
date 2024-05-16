package com.piterrus.dagger2.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.piterrus.dagger2.App
import com.piterrus.dagger2.di.activity.binds.DaggerBindsActivityComponent
import com.piterrus.dagger2.presentation.first_screen.ui.FirstScreen
import com.piterrus.dagger2.ui.theme.Dagger2TraineeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val activityComponent = remember {
                DaggerBindsActivityComponent.builder()
                    .appComponent(App.appComponent)
                    .build()
            }
//            val activityComponent = remember {
//                DaggerProvidesActivityComponent.builder()
//                    .appComponent(App.appComponent)
//                    .build()
//            }
            val viewModel: ActivityViewModel = if (com.piterrus.dagger2.BuildConfig.type == "first") {
                remember { activityComponent.getFirstActivityViewModel() }
            } else {
                remember { activityComponent.getSecondActivityViewModel() }
            }
            val string = viewModel.activityState.collectAsState()
            LaunchedEffect(key1 = true) {
                viewModel.getString()
            }
            Dagger2TraineeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FirstScreen(
                        text = string.value
                    )
                }
            }
        }
    }
}
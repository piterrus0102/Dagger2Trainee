package com.piterrus.dagger2.presentation.activity

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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.piterrus.dagger2.App
import com.piterrus.dagger2.navigation.Screens
import com.piterrus.dagger2.presentation.binds_screen.ui.BindsScreen
import com.piterrus.dagger2.presentation.provides_screen.ui.ProvidesScreen
import com.piterrus.dagger2.ui.theme.Dagger2TraineeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Dagger2TraineeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Screens.MainActivity.route) {
                        composable(
                            route = Screens.MainActivity.route
                        ) {
                            MainActivityView(
                                onIntent = {
                                    when (it) {
                                        MainActivityIntent.OnProvidesClick -> {
                                           navController.navigate(Screens.ProvidesScreen.route)
                                        }

                                        MainActivityIntent.OnBindsClick -> {
                                            navController.navigate(Screens.BindsScreen.route)
                                        }
                                    }
                                }
                            )
                        }
                        composable(
                            route = Screens.ProvidesScreen.route
                        ) {
                            ProvidesScreen()
                        }
                        composable(
                            route = Screens.BindsScreen.route
                        ) {
                            BindsScreen()
                        }
                    }
                }
            }
        }
    }
}
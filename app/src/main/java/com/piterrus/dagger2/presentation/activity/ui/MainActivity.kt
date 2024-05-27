package com.piterrus.dagger2.presentation.activity.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.piterrus.dagger2.navigation.NavHostScreen
import com.piterrus.dagger2.compose.components.TopNavBar
import com.piterrus.dagger2.compose.theme.Dagger2TraineeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            var topNavBarTitle by remember { mutableStateOf("") }
            val navBackLambda = remember { mutableStateOf<(() -> Unit)?>(null) }
            navController.addOnDestinationChangedListener { controller, _, _ ->
                if (controller.previousBackStackEntry != null) {
                    navBackLambda.value = {
                        navController.popBackStack()
                    }
                } else {
                    topNavBarTitle = ""
                    navBackLambda.value = null
                }

            }
            Dagger2TraineeTheme {
                Scaffold(
                    topBar = {
                        TopNavBar(
                            title = topNavBarTitle,
                            onBackButtonClicked = navBackLambda.value,
                            onNextButtonClicked = null
                        )
                    },
                    content = { padding ->
                        Surface(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(padding)
                            ,
                            color = MaterialTheme.colorScheme.background
                        ) {
                            NavHostScreen(
                                navController = navController,
                                onChangeTitle = {
                                    topNavBarTitle = it
                                }
                            )
                        }
                    }
                )
            }
        }
    }

    private fun getLambda(title: String): (() -> Unit)? {
        return if (title.isEmpty()) {
            null
        } else {
            ::initializeViewTreeOwners
        }
    }
}
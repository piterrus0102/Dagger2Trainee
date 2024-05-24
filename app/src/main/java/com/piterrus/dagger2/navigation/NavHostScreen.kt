package com.piterrus.dagger2.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.piterrus.dagger2.R
import com.piterrus.dagger2.presentation.activity.MainActivityIntent
import com.piterrus.dagger2.presentation.activity.MainActivityView
import com.piterrus.dagger2.presentation.binds_instance.ui.BindsInstanceScreen
import com.piterrus.dagger2.presentation.binds_screen.ui.BindsScreen
import com.piterrus.dagger2.presentation.builder_screen.ui.BuilderScreen
import com.piterrus.dagger2.presentation.inject_method_screen.ui.InjectMethodScreen
import com.piterrus.dagger2.presentation.into_set_and_into_map_screen.ui.IntoSetAndIntoMapScreen
import com.piterrus.dagger2.presentation.provides_screen.ui.ProvidesScreen

@Composable
fun NavHostScreen(
    navController: NavHostController,
    onChangeTitle: (String) -> Unit
) {
    val context = LocalContext.current
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
                            onChangeTitle.invoke(context.getString(R.string.provides))
                            navController.navigate(Screens.ProvidesScreen.route)
                        }

                        MainActivityIntent.OnBindsClick -> {
                            onChangeTitle.invoke(context.getString(R.string.binds))
                            navController.navigate(Screens.BindsScreen.route)
                        }

                        MainActivityIntent.OnIntoSetAndIntoMapClick -> {
                            onChangeTitle.invoke(context.getString(R.string.into_set_and_into_map))
                            navController.navigate(Screens.IntoSetAndIntoMaScreen.route)
                        }

                        MainActivityIntent.OnInjectMethodClick -> {
                            onChangeTitle.invoke(context.getString(R.string.class_with_inject_methods))
                            navController.navigate(Screens.InjectMethodScreen.route)
                        }

                        MainActivityIntent.OnBuilderClick -> {
                            onChangeTitle.invoke(context.getString(R.string.component_builder))
                            navController.navigate(Screens.BuilderScreen.route)
                        }

                        MainActivityIntent.OnBindsInstanceClick -> {
                            onChangeTitle.invoke(context.getString(R.string.binds_instance))
                            navController.navigate(Screens.BindsInstanceScreen.route)
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

        composable(
            route = Screens.IntoSetAndIntoMaScreen.route
        ) {
            IntoSetAndIntoMapScreen()
        }

        composable(
            route = Screens.InjectMethodScreen.route
        ) {
            InjectMethodScreen()
        }

        composable(
            route = Screens.BuilderScreen.route
        ) {
            BuilderScreen()
        }

        composable(
            route = Screens.BindsInstanceScreen.route
        ) {
            BindsInstanceScreen()
        }
    }
}
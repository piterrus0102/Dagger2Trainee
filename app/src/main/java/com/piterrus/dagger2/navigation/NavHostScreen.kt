package com.piterrus.dagger2.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.piterrus.dagger2.R
import com.piterrus.dagger2.presentation.activity.ui.MainActivityIntent
import com.piterrus.dagger2.presentation.activity.ui.MainActivityView
import com.piterrus.dagger2.presentation.binds_instance.ui.BindsInstanceScreen
import com.piterrus.dagger2.presentation.binds_screen.ui.BindsScreen
import com.piterrus.dagger2.presentation.builder_and_factory_screen.ui.BuilderAndFactoryScreen
import com.piterrus.dagger2.presentation.inject_method_screen.ui.InjectMethodScreen
import com.piterrus.dagger2.presentation.into_set_and_into_map_screen.ui.IntoSetAndIntoMapScreen
import com.piterrus.dagger2.presentation.provides_screen.ui.ProvidesScreen
import com.piterrus.dagger2.presentation.subcomponent_screen.ui.SubcomponentScreen

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

                        MainActivityIntent.OnBuilderAndFactoryClick -> {
                            onChangeTitle.invoke(context.getString(R.string.component_builder_and_component_factory))
                            navController.navigate(Screens.BuilderAndFactoryScreen.route)
                        }

                        MainActivityIntent.OnBindsInstanceClick -> {
                            onChangeTitle.invoke(context.getString(R.string.binds_instance))
                            navController.navigate(Screens.BindsInstanceScreen.route)
                        }

                        MainActivityIntent.OnSubcomponentClick -> {
                            onChangeTitle.invoke(context.getString(R.string.subcomponent))
                            navController.navigate(Screens.SubcomponentScreen.route)
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
            route = Screens.BuilderAndFactoryScreen.route
        ) {
            BuilderAndFactoryScreen()
        }

        composable(
            route = Screens.BindsInstanceScreen.route
        ) {
            BindsInstanceScreen()
        }

        composable(
            route = Screens.SubcomponentScreen.route
        ) {
            SubcomponentScreen()
        }
    }
}
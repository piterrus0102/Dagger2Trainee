package com.piterrus.dagger2.navigation

enum class Screens(val route: String) {
    MainActivity("MainActivity"),
    ProvidesScreen("ProvidesScreen"),
    BindsScreen("BindsScreen"),
    IntoSetAndIntoMaScreen("IntoSetAndIntoMaScreen"),
    InjectMethodScreen("InjectMethodScreen"),
    BuilderAndFactoryScreen("BuilderAndFactoryScreen"),
    BindsInstanceScreen("BindsInstanceScreen"),
    SubcomponentScreen("SubcomponentScreen")
}
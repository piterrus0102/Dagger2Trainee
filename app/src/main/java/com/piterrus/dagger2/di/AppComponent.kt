package com.piterrus.dagger2.di

import android.content.Context
import android.content.SharedPreferences
import com.piterrus.dagger2.App
import com.piterrus.dagger2.presentation.subcomponent_screen.di.Subcomponent
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.CoroutineDispatcher


@AppScope
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {

    fun context(): Context
    fun coroutineDispatcher(): CoroutineDispatcher
    fun appSharedPreferences(): SharedPreferences

    fun getSubcomponent(): Subcomponent
}
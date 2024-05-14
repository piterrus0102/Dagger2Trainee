package com.piterrus.dagger2.di

import android.content.Context
import android.content.SharedPreferences
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
}
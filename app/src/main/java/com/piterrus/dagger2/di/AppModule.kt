package com.piterrus.dagger2.di

import android.content.Context
import android.content.SharedPreferences
import com.piterrus.dagger2.App
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class AppModule(private val context: Context) {

    @Provides
    @AppScope
    fun provideContext(): Context {
        return context
    }

    @Provides
    @AppScope
    fun provideCoroutineDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @[Provides AppScope]
    fun provideSharedPreferences(): SharedPreferences {
        return context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    }
}
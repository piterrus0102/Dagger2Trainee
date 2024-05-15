package com.piterrus.dagger2.di

import android.content.Context
import android.content.SharedPreferences
import com.piterrus.dagger2.App
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class AppModule {

    @Provides
    @AppScope
    fun provideCoroutineDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @[Provides AppScope]
    fun provideSharedPreferences(app: App): SharedPreferences {
        return app.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    }
}
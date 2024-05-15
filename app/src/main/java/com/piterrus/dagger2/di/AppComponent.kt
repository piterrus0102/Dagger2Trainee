package com.piterrus.dagger2.di

import android.content.SharedPreferences
import com.piterrus.dagger2.App
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

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        @BindsInstance
        fun application(application: App): Builder
    }
    fun coroutineDispatcher(): CoroutineDispatcher
    fun appSharedPreferences(): SharedPreferences
}
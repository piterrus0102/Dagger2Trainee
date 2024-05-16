package com.piterrus.dagger2.presentation.first_screen.di

import android.util.Log
import dagger.Module
import dagger.Provides

@Module
class StringFromDaggerModule {

    @Provides
    fun stringFromDagger(): String {
        Log.e("GETTER", "DAGGER")
        return "stringFromDagger"
    }
}
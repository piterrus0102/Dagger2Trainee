package com.piterrus.dagger2.di.modules.lazy

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.internal.SetBuilder

@Module
class StringFromDaggerModule {

    @Provides
    fun stringFromDagger(): String {
        return "stringFromDagger"
    }
}
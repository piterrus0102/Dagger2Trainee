package com.piterrus.dagger2.di.modules.builder

import dagger.Module
import dagger.Provides

@Module
class BuilderModule(private val stringWhichSetValueDuringBuilding: String) {

    @Provides
    fun getStringWhichSetValueDuringBuilding(): String {
        return stringWhichSetValueDuringBuilding
    }

}
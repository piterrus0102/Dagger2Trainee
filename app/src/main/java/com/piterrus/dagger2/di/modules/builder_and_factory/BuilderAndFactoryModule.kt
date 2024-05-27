package com.piterrus.dagger2.di.modules.builder_and_factory

import dagger.Module
import dagger.Provides

@Module
class BuilderAndFactoryModule(private val stringWhichSetValueDuringBuilding: String) {

    @Provides
    fun getStringWhichSetValueDuringBuilding(): String {
        return stringWhichSetValueDuringBuilding
    }

}
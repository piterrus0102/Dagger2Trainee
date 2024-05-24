package com.piterrus.dagger2.di.modules.binds_instance

import dagger.Module
import dagger.Provides

@Module
class BindsInstanceModule {

    @Provides
    @BindsInstanceProvidesByModule
    fun getStringWhichSetValueDuringBuilding(string: String): String {
        return string
    }

}
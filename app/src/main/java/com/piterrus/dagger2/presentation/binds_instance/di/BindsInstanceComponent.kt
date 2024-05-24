package com.piterrus.dagger2.presentation.binds_instance.di

import com.piterrus.dagger2.di.AppComponent
import com.piterrus.dagger2.di.FeatureScope
import com.piterrus.dagger2.di.modules.binds_instance.BindsInstanceModule
import com.piterrus.dagger2.di.modules.binds_instance.BindsInstanceProvidesByModule
import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component(
    modules = [
        BindsInstanceModule::class
    ],
    dependencies = [AppComponent::class]
)
interface BindsInstanceComponent {

    @Component.Builder
    interface BindsInstanceBuilder {
        fun appComponent(appComponent: AppComponent): BindsInstanceBuilder
        @BindsInstance
        fun string(string: String): BindsInstanceBuilder
        fun buildBindsInstanceComponent() : BindsInstanceComponent
    }
    //String Provided by @BindsInstance
    fun stringByBindsInstance(): String
    @BindsInstanceProvidesByModule
    fun stringByModule(): String
}
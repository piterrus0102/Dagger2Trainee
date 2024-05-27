package com.piterrus.dagger2.presentation.builder_and_factory_screen.di

import com.piterrus.dagger2.di.AppComponent
import com.piterrus.dagger2.di.FeatureScope
import com.piterrus.dagger2.di.modules.builder_and_factory.BuilderAndFactoryModule
import dagger.Component

@FeatureScope
@Component(
    modules = [
        BuilderAndFactoryModule::class
    ],
    dependencies = [AppComponent::class]
)
interface FactoryComponent {

    @Component.Factory
    interface ComponentFactory {
        fun create(appComponent: AppComponent, builderAndFactoryModule: BuilderAndFactoryModule): FactoryComponent
    }

    fun getStringWhichSetValueDuringBuilding(): String
}
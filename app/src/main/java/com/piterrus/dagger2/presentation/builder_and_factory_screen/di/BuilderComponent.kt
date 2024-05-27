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
interface BuilderComponent {

    @Component.Builder
    interface BuilderDaggerBuilder {
        fun appComponent(appComponent: AppComponent): BuilderDaggerBuilder
        fun builderModule(builderAndFactoryModule: BuilderAndFactoryModule): BuilderDaggerBuilder
        fun buildBuilderComponent() : BuilderComponent
    }

    fun getStringWhichSetValueDuringBuilding(): String
}
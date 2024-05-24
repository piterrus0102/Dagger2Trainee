package com.piterrus.dagger2.presentation.builder_screen.di

import com.piterrus.dagger2.di.AppComponent
import com.piterrus.dagger2.di.FeatureScope
import com.piterrus.dagger2.di.modules.builder.BuilderModule
import dagger.Component


@FeatureScope
@Component(
    modules = [
        BuilderModule::class
    ],
    dependencies = [AppComponent::class]
)
interface BuilderComponent {

    @Component.Builder
    interface BuilderDaggerBuilder {
        fun appComponent(appComponent: AppComponent): BuilderDaggerBuilder
        fun builderModule(builderModule: BuilderModule): BuilderDaggerBuilder
        fun buildBuilderComponent() : BuilderComponent
    }

    fun getStringWhichSetValueDuringBuilding(): String
}
package com.piterrus.dagger2.presentation.first_screen.di

import com.piterrus.dagger2.di.AppComponent
import com.piterrus.dagger2.di.FeatureScope
import dagger.Component
import dagger.Lazy


@FeatureScope
@Component(
    modules = [
        StringFromDaggerModule::class
    ],
    dependencies = [AppComponent::class]
)
interface FirstScreenComponent {
    fun lazyStringFromDagger(): Lazy<String>
}
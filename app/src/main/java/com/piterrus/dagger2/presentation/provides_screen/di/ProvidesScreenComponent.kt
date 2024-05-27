package com.piterrus.dagger2.presentation.provides_screen.di

import com.piterrus.dagger2.di.AppComponent
import com.piterrus.dagger2.di.FeatureScope
import com.piterrus.dagger2.di.First
import com.piterrus.dagger2.di.Second
import com.piterrus.dagger2.di.modules.lazy.StringFromDaggerModule
import com.piterrus.dagger2.di.modules.provides.ProvidesActivityModule
import com.piterrus.dagger2.presentation.activity.ui.MainActivityViewModel
import dagger.Component
import dagger.Lazy


@FeatureScope
@Component(
    modules = [
        ProvidesActivityModule::class,
        StringFromDaggerModule::class
    ],
    dependencies = [AppComponent::class]
)
interface ProvidesScreenComponent {
    @Second
    fun getSecondActivityViewModel(): MainActivityViewModel
    @First
    fun getFirstActivityViewModel(): MainActivityViewModel
    fun lazyStringFromDagger(): Lazy<String>
}
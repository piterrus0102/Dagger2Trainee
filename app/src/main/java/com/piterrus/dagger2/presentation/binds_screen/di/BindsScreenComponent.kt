package com.piterrus.dagger2.presentation.binds_screen.di

import com.piterrus.dagger2.di.AppComponent
import com.piterrus.dagger2.di.FeatureScope
import com.piterrus.dagger2.di.First
import com.piterrus.dagger2.di.Second
import com.piterrus.dagger2.di.modules.binds.BindsActivityModule
import com.piterrus.dagger2.di.modules.binds.BindsViewModelModule
import com.piterrus.dagger2.di.modules.lazy.StringFromDaggerModule
import com.piterrus.dagger2.presentation.activity.ui.MainActivityViewModel
import dagger.Component
import dagger.Lazy


@FeatureScope
@Component(
    modules = [
        BindsActivityModule::class,
        BindsViewModelModule::class,
        StringFromDaggerModule::class
    ],
    dependencies = [AppComponent::class]
)
interface BindsScreenComponent {
    @Second
    fun getSecondActivityViewModel(): MainActivityViewModel
    @First
    fun getFirstActivityViewModel(): MainActivityViewModel
    fun lazyStringFromDagger(): Lazy<String>
}
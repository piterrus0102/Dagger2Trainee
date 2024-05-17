package com.piterrus.dagger2.di.activity.provides

import com.piterrus.dagger2.di.AppComponent
import com.piterrus.dagger2.di.FeatureScope
import com.piterrus.dagger2.di.First
import com.piterrus.dagger2.di.Second
import com.piterrus.dagger2.di.modules.provides.ProvidesActivityModule
import com.piterrus.dagger2.presentation.ActivityViewModel
import dagger.Component

@FeatureScope
@Component(
    modules = [
        ProvidesActivityModule::class
    ],
    dependencies = [AppComponent::class]
)
interface ProvidesActivityComponent {
    @Second
    fun getSecondActivityViewModel(): ActivityViewModel
    @First
    fun getFirstActivityViewModel(): ActivityViewModel
}
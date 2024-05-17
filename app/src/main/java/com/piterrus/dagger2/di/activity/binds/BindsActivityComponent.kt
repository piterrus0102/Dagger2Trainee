package com.piterrus.dagger2.di.activity.binds

import com.piterrus.dagger2.di.AppComponent
import com.piterrus.dagger2.di.FeatureScope
import com.piterrus.dagger2.di.First
import com.piterrus.dagger2.di.Second
import com.piterrus.dagger2.di.modules.binds.BindsActivityModule
import com.piterrus.dagger2.di.modules.binds.BindsViewModelModule
import com.piterrus.dagger2.presentation.ActivityViewModel
import dagger.Component

@FeatureScope
@Component(
    modules = [
        BindsActivityModule::class,
        BindsViewModelModule::class
    ],
    dependencies = [AppComponent::class]
)
interface BindsActivityComponent {
    @Second
    fun getSecondActivityViewModel(): ActivityViewModel
    @First
    fun getFirstActivityViewModel(): ActivityViewModel
}
package com.piterrus.dagger2.presentation.first_screen.di

import com.piterrus.dagger2.di.AppComponent
import com.piterrus.dagger2.di.FeatureScope
import com.piterrus.dagger2.di.modules.into_set_and_into_map.IntoMapModule
import com.piterrus.dagger2.di.modules.into_set_and_into_map.IntoSetModule
import com.piterrus.dagger2.di.modules.lazy.StringFromDaggerModule
import com.piterrus.dagger2.domain.into_set_and_into_map.PrintersAndLoggers
import dagger.Component
import dagger.Lazy


@FeatureScope
@Component(
    modules = [
        StringFromDaggerModule::class,
        IntoSetModule::class,
        IntoMapModule::class
    ],
    dependencies = [AppComponent::class]
)
interface FirstScreenComponent {
    fun lazyStringFromDagger(): Lazy<String>
    fun getPrintersAndLoggersSet(): Set<PrintersAndLoggers>
    fun getPrintersAndLoggersMap(): Map<String, PrintersAndLoggers>
}
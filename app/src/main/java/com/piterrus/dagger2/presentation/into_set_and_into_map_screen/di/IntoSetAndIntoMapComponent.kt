package com.piterrus.dagger2.presentation.into_set_and_into_map_screen.di

import com.piterrus.dagger2.di.AppComponent
import com.piterrus.dagger2.di.FeatureScope
import com.piterrus.dagger2.di.modules.into_set_and_into_map.IntoMapModule
import com.piterrus.dagger2.di.modules.into_set_and_into_map.IntoSetModule
import com.piterrus.dagger2.domain.into_set_and_into_map.PrintersAndLoggers
import dagger.Component

@FeatureScope
@Component(
    modules = [
        IntoMapModule::class,
        IntoSetModule::class,
    ],
    dependencies = [AppComponent::class]
)
interface IntoSetAndIntoMapComponent {
    fun getPrintersAndLoggersSet(): Set<PrintersAndLoggers>
    fun getPrintersAndLoggersMap(): Map<String, PrintersAndLoggers>
}
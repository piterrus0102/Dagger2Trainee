package com.piterrus.dagger2.presentation.inject_method_screen.di

import com.piterrus.dagger2.di.AppComponent
import com.piterrus.dagger2.di.FeatureScope
import com.piterrus.dagger2.di.modules.into_set_and_into_map.IntoMapModule
import com.piterrus.dagger2.di.modules.into_set_and_into_map.IntoSetModule
import com.piterrus.dagger2.domain.inject_method.ClassWithInjectedMethod
import com.piterrus.dagger2.domain.into_set_and_into_map.PrintersAndLoggers
import dagger.Component

@FeatureScope
@Component(
    dependencies = [AppComponent::class]
)
interface InjectMethodComponent {
    fun getClassWithInjectedMethod(): ClassWithInjectedMethod
}
package com.piterrus.dagger2.presentation.provides_screen.di

import com.piterrus.dagger2.di.AppComponent
import com.piterrus.dagger2.di.FeatureScope
import com.piterrus.dagger2.di.First
import com.piterrus.dagger2.di.Second
import com.piterrus.dagger2.di.modules.into_set_and_into_map.IntoMapModule
import com.piterrus.dagger2.di.modules.into_set_and_into_map.IntoSetModule
import com.piterrus.dagger2.di.modules.lazy.StringFromDaggerModule
import com.piterrus.dagger2.di.modules.provides.ProvidesActivityModule
import com.piterrus.dagger2.domain.inject_method.ClassWithInjectedMethod
import com.piterrus.dagger2.domain.into_set_and_into_map.PrintersAndLoggers
import com.piterrus.dagger2.presentation.activity.MainActivityViewModel
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

//@FeatureScope
//@Component(
//    modules = [
//        StringFromDaggerModule::class,
//        IntoSetModule::class,
//        IntoMapModule::class
//    ],
//    dependencies = [AppComponent::class]
//)
//interface ProvidesScreenComponent {
//    fun lazyStringFromDagger(): Lazy<String>
//    fun getPrintersAndLoggersSet(): Set<PrintersAndLoggers>
//    fun getPrintersAndLoggersMap(): Map<String, PrintersAndLoggers>
//    fun getClassWithInjectedMethod(): ClassWithInjectedMethod
//}
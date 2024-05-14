package com.piterrus.dagger2.di

import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FeatureScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope
package com.piterrus.dagger2.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class First

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Second
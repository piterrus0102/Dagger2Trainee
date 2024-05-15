package com.piterrus.dagger2.di.activity.binds

import com.piterrus.dagger2.di.FeatureScope
import com.piterrus.dagger2.di.First
import com.piterrus.dagger2.di.Second
import com.piterrus.dagger2.domain.UseCase
import com.piterrus.dagger2.domain.binds.ReturnStringUseCase2Binds
import com.piterrus.dagger2.domain.binds.ReturnStringUseCaseBinds
import dagger.Binds
import dagger.Module


@Module
abstract class BindsActivityModule {

    @Binds
    @First
    @FeatureScope
    abstract fun firstUseCase(useCase: ReturnStringUseCaseBinds): UseCase

    @Binds
    @Second
    @FeatureScope
    abstract fun secondUseCase(useCase: ReturnStringUseCase2Binds): UseCase
}
package com.piterrus.dagger2.di.modules.provides

import com.piterrus.dagger2.di.FeatureScope
import com.piterrus.dagger2.di.First
import com.piterrus.dagger2.di.Second
import com.piterrus.dagger2.domain.UseCase
import com.piterrus.dagger2.domain.provides.ReturnStringUseCase2Provides
import com.piterrus.dagger2.domain.provides.ReturnStringUseCaseProvides
import com.piterrus.dagger2.presentation.ActivityViewModel
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher

@Module
class ProvidesActivityModule {

    @Provides
    @First
    @FeatureScope
    fun firstUseCase(): UseCase {
        return ReturnStringUseCaseProvides()
    }

    @Provides
    @Second
    @FeatureScope
    fun secondUseCase(): UseCase {
        return ReturnStringUseCase2Provides()
    }

    @Provides
    @First
    @FeatureScope
    fun viewModelFirst(
        @First activityUseCase: UseCase,
        coroutineDispatcher: CoroutineDispatcher
    ): ActivityViewModel {
        return ActivityViewModel(activityUseCase, coroutineDispatcher)
    }

    @Provides
    @Second
    @FeatureScope
    fun viewModelSecond(
        @Second activityUseCase: UseCase,
        coroutineDispatcher: CoroutineDispatcher
    ): ActivityViewModel {
        return ActivityViewModel(activityUseCase, coroutineDispatcher)
    }

}
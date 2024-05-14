package com.piterrus.dagger2.di.activity

import com.piterrus.dagger2.di.FeatureScope
import com.piterrus.dagger2.di.First
import com.piterrus.dagger2.di.Second
import com.piterrus.dagger2.domain.ReturnStringUseCase
import com.piterrus.dagger2.domain.ReturnStringUseCase2
import com.piterrus.dagger2.domain.UseCase
import com.piterrus.dagger2.presentation.ActivityViewModel
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher

@Module
class ActivityModule {

    @Provides
    @First
    @FeatureScope
    fun firstUseCase(): UseCase {
        return ReturnStringUseCase()
    }

    @Provides
    @Second
    @FeatureScope
    fun secondUseCase(): UseCase {
        return ReturnStringUseCase2()
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
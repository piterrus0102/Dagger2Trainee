package com.piterrus.dagger2.di.modules.binds

import com.piterrus.dagger2.di.FeatureScope
import com.piterrus.dagger2.di.First
import com.piterrus.dagger2.di.Second
import com.piterrus.dagger2.domain.UseCase
import com.piterrus.dagger2.presentation.activity.ui.MainActivityViewModel
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher

@Module
class BindsViewModelModule {

    @Provides
    @First
    @FeatureScope
    fun viewModelFirst(
        @First activityUseCase: UseCase,
        coroutineDispatcher: CoroutineDispatcher
    ): MainActivityViewModel {
        return MainActivityViewModel(activityUseCase, coroutineDispatcher)
    }

    @Provides
    @Second
    @FeatureScope
    fun viewModelSecond(
        @Second activityUseCase: UseCase,
        coroutineDispatcher: CoroutineDispatcher
    ): MainActivityViewModel {
        return MainActivityViewModel(activityUseCase, coroutineDispatcher)
    }
}
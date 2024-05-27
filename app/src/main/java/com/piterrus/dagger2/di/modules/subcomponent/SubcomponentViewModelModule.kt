package com.piterrus.dagger2.di.modules.subcomponent

import android.content.Context
import com.piterrus.dagger2.presentation.subcomponent_screen.ui.SubcomponentViewModel
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher

@Module
class SubcomponentViewModelModule {

    @Provides
    fun provideSubcomponent(
        coroutineDispatcher: CoroutineDispatcher,
        context: Context
    ) : SubcomponentViewModel {
        return SubcomponentViewModel(coroutineDispatcher, context)
    }

}
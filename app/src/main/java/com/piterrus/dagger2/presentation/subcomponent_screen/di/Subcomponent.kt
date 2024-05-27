package com.piterrus.dagger2.presentation.subcomponent_screen.di

import com.piterrus.dagger2.di.modules.subcomponent.SubcomponentViewModelModule
import com.piterrus.dagger2.presentation.subcomponent_screen.ui.SubcomponentViewModel
import dagger.Subcomponent

@Subcomponent(
    modules = [
        SubcomponentViewModelModule::class
    ]
)
interface Subcomponent {
    fun getSubcomponentViewModel(): SubcomponentViewModel
}
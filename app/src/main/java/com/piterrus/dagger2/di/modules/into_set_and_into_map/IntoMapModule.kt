package com.piterrus.dagger2.di.modules.into_set_and_into_map

import com.piterrus.dagger2.domain.into_set_and_into_map.Logger
import com.piterrus.dagger2.domain.into_set_and_into_map.Printer
import com.piterrus.dagger2.domain.into_set_and_into_map.PrintersAndLoggers
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
class IntoMapModule {

    @StringKey(Printer.KEY)
    @IntoMap
    @Provides
    fun printer() : PrintersAndLoggers {
        return Printer()
    }

    @StringKey(Logger.KEY)
    @IntoMap
    @Provides
    fun logger() : PrintersAndLoggers {
        return Logger()
    }

}
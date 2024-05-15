package com.piterrus.dagger2

import androidx.multidex.MultiDexApplication
import com.piterrus.dagger2.di.AppComponent
import com.piterrus.dagger2.di.DaggerAppComponent

class App : MultiDexApplication() {

    companion object {
        lateinit var appComponent: AppComponent
    }


    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .application(this)
            .build()

    }

}
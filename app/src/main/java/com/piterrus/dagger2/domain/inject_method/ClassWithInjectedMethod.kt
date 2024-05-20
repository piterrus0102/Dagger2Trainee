package com.piterrus.dagger2.domain.inject_method

import android.util.Log
import javax.inject.Inject

/**
 *
 *  This class show executing @Inject methods via init class methods.
 *
 *  After injecting and initializing this class by Dagger2:
 *
 *  1) Initialization methods are executed first in up-to-down order.
 *
 *  2) Then @Injects methods are executed in up-to-down order.
 *
 *  In this example init log will look as follows:
 *
 *  1) This log was written into init method;
 *
 *  2) This log was written into init method 2;
 *
 *  3) This log was written into injected method;
 *
 *  4) This log was written into injected method 2.
 */

class ClassWithInjectedMethod @Inject constructor() {

    init {
        Log.e("InjectedClass", "This log was written into init method")
    }

    @Inject
    fun postInit() {
        Log.e("InjectedClass", "This log was written into injected method")
    }

    init {
        Log.e("InjectedClass", "This log was written into init method 2")
    }

    @Inject
    fun postInit2() {
        Log.e("InjectedClass", "This log was written into injected method 2")
    }
}
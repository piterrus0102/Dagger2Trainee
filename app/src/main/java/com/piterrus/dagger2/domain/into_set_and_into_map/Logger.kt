package com.piterrus.dagger2.domain.into_set_and_into_map

import android.util.Log

class Logger : PrintersAndLoggers {

    companion object {
        const val KEY = "LOGGER"
    }

    override fun print(string: String) {
        Log.e(KEY, string)
    }
}
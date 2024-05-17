package com.piterrus.dagger2.domain.into_set_and_into_map

class Printer : PrintersAndLoggers {

    companion object {
        const val KEY = "PRINTER"
    }

    override fun print(string: String) {
        println(string)
    }
}
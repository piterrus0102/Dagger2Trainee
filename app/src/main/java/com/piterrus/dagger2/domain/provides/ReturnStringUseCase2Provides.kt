package com.piterrus.dagger2.domain.provides

import com.piterrus.dagger2.domain.UseCase

class ReturnStringUseCase2Provides: UseCase {

    override fun getString(): String = "second use case"

}
package com.piterrus.dagger2.domain.provides

import com.piterrus.dagger2.domain.UseCase

class ReturnStringUseCaseProvides: UseCase {

    override fun getString(): String = "first use case"

}
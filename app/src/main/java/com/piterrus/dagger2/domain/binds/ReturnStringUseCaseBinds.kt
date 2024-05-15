package com.piterrus.dagger2.domain.binds

import com.piterrus.dagger2.domain.UseCase
import javax.inject.Inject

class ReturnStringUseCaseBinds @Inject constructor(): UseCase {

    override fun getString(): String = "first use case"

}
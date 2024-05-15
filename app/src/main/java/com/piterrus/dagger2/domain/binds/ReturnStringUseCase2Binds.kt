package com.piterrus.dagger2.domain.binds

import com.piterrus.dagger2.domain.UseCase
import javax.inject.Inject

class ReturnStringUseCase2Binds @Inject constructor(): UseCase {

    override fun getString(): String = "second use case"

}
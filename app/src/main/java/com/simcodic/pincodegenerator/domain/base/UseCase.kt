package com.simcodic.pincodegenerator.domain.base

import com.simcodic.pincodegenerator.domain.base.UseCaseData.Input
import com.simcodic.pincodegenerator.domain.base.UseCaseData.Output
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface UseCase<in Y : Input, out T : Output> {

    fun run(input: Y): T

    suspend operator fun invoke(input: Y): T = withContext(Dispatchers.IO) {
        run(input)
    }
}

interface UseCaseData {
    interface Input
    interface Output
    object NonInput : Input
    object NonOutput : Output
}
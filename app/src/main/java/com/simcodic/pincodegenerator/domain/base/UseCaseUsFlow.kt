package com.simcodic.pincodegenerator.domain.base

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface UseCaseUsFlow<out T> {

    suspend fun run(): T

    suspend operator fun invoke(): T = withContext(Dispatchers.IO) {
        run()
    }
}
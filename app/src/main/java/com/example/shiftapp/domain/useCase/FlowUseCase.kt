package com.example.shiftapp.domain.useCase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

interface FlowUseCase<in Input, Output> {
    val dispatcher: CoroutineDispatcher

    operator fun invoke(param: Input): Flow<Result<Output>> =
        execute(param)
            .catch { e -> emit(Result.failure(e)) }
            .flowOn(dispatcher)

    fun execute(param: Input): Flow<Result<Output>>
}
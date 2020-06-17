package com.konstload.chatmessanger.domain.interactor

import com.konstload.chatmessanger.domain.type.Either
import com.konstload.chatmessanger.domain.type.Failure
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 * Абстрактный(обобщающий) параметризированный класс.
 * Оперирует двумя параметризированными типами:
 * Type(тип возвращаемого объекта с данными)
 * Params(тип класса-оболочки, хранящей параметры для выполнения функции)
 */

abstract class UseCase<out Type, in Params> {
    var backgroundContext: CoroutineContext = Dispatchers.IO
    var foregroundContext: CoroutineContext = Dispatchers.Main

    private var parentJob: Job = Job()

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit = {}) {
        unsubscribe()
        parentJob = Job()

        CoroutineScope(foregroundContext + parentJob).launch {
            val result = withContext(backgroundContext) {
                run(params)
            }
            onResult(result)
        }
    }

    fun unsubscribe() {
        parentJob.apply {
            cancelChildren()
            cancel()
        }
    }
}
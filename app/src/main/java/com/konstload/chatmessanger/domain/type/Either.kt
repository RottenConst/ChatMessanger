package com.konstload.chatmessanger.domain.type

/**
 * Параметризированный класс-обертка. Содержит в себе: два типа данных(Left и Right);
 * [Left] используется для 'неудачи'
 * [Right] используется для 'успеха'
 *
 * @see Left
 * @see Right
 */

sealed class Either<out L, out R> {
    /** * Содержит в себе левую часть класса [Either] - "Отказ" */
    data class Left<out L>(val a: L) : Either<L, Nothing>()

    /** * Содержит в себе правую часть класса [Either] - "Успех" */
    data class Right<out R>(val b: R) : Either<Nothing, R>()

    private val isRight get() = this is Right<R>
    private val isLeft get() = this is Left<L>

    fun <L> left(a: L) = Left(a)
    fun <R> right(b: R) = Right(b)

    fun either(functionLeft: (L) -> Any, functionRight: (R) -> Any): Any =
        when (this) {
            is Left -> functionLeft(a)
            is Right -> functionRight(b)
        }
}

fun <A, B, C> ((A) -> B).compose(f: (B) -> C): (A) -> C = {
    f(this(it))
}

fun <T, L, R> Either<L,R>.flatMap(fn: (R) -> Either<L, T>): Either<L, T> {
    return when (this) {
        is Either.Left -> Either.Left(a)
        is Either.Right -> fn(b)
    }
}

fun <T, L, R> Either<L,R>.map(fn: (R) -> (T)): Either<L, T> {
    return this.flatMap(fn.compose(::right))
}

fun <L, R> Either<L,R>.onNext(fn: (R) -> Unit): Either<L, R> {
    this.flatMap(fn.compose(::right))
    return this
}
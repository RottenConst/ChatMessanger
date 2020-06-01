package com.konstload.chatmessanger.data.account

import com.konstload.chatmessanger.domain.type.Either
import com.konstload.chatmessanger.domain.type.None
import com.konstload.chatmessanger.domain.type.exception.Failure

/**
 * Интерфейс, содержащий функции для взаимодействия с аккаунтом на сервере
 */
interface AccountRemote {
    fun register(
        email: String,
        name: String,
        password: String,
        token: String,
        userDate: Long
    ): Either<Failure, None>
}
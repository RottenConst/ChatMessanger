package com.konstload.chatmessanger.data.account

import com.konstload.chatmessanger.domain.type.Either
import com.konstload.chatmessanger.domain.type.None
import com.konstload.chatmessanger.domain.type.exception.Failure

/**
 * Интерфейс, содержащий функции для взаимодействия с аккаунтом в локальной базе данных
 */
interface AccountCache {
    fun getToken(): Either<Failure, String>
    fun saveToken(token: String): Either<Failure, None>
}
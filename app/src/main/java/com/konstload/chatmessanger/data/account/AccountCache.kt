package com.konstload.chatmessanger.data.account

import com.konstload.chatmessanger.domain.account.AccountEntity
import com.konstload.chatmessanger.domain.type.Either
import com.konstload.chatmessanger.domain.type.None
import com.konstload.chatmessanger.domain.type.Failure

/**
 * Интерфейс, содержащий функции для взаимодействия с аккаунтом в локальной базе данных
 */
interface AccountCache {
    fun getToken(): Either<Failure, String>
    fun saveToken(token: String): Either<Failure, None>

    fun logout(): Either<Failure, None>

    fun getCurrentAccount(): Either<Failure, AccountEntity>
    fun saveAccount(account: AccountEntity): Either<Failure, None>
}
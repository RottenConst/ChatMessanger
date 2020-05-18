package com.konstload.chatmessanger.cache

import com.konstload.chatmessanger.data.account.AccountCache
import com.konstload.chatmessanger.domain.type.Either
import com.konstload.chatmessanger.domain.type.None
import com.konstload.chatmessanger.domain.type.exception.Failure
import javax.inject.Inject

/**
 * Класс, содержащий функции взаимодействия с аккаунтом в бд
 */
class AccountCacheImpl @Inject constructor(private val prefsManager: SharedPrefsManager) : AccountCache {

    override fun saveToken(token: String): Either<Failure, None> {
        return prefsManager.saveToken(token)
    }

    override fun getToken(): Either<Failure, String?> {
        return prefsManager.getToken()
    }
}
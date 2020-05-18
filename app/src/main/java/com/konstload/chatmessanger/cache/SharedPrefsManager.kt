package com.konstload.chatmessanger.cache

import android.content.SharedPreferences
import com.konstload.chatmessanger.domain.type.Either
import com.konstload.chatmessanger.domain.type.None
import com.konstload.chatmessanger.domain.type.exception.Failure
import javax.inject.Inject

/**
 * Класс для работы с SharedPreferences
 * для сохранения и востановления данных
 */
class SharedPrefsManager @Inject constructor(private val prefs: SharedPreferences) {
    companion object {
        const val ACCOUNT_TOKEN = "account_token"
    }

    fun saveToken(token: String): Either<Failure, None> {
        prefs.edit().apply {
            putString(ACCOUNT_TOKEN, token)
        }.apply()

        return Either.Right(None())
    }

    fun getToken(): Either<Failure, String?> {
        return Either.Right(prefs.getString(ACCOUNT_TOKEN, ""))
    }
}
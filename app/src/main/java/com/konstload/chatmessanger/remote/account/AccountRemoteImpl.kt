package com.konstload.chatmessanger.remote.account

import com.konstload.chatmessanger.data.account.AccountRemote
import com.konstload.chatmessanger.domain.type.Either
import com.konstload.chatmessanger.domain.type.None
import com.konstload.chatmessanger.domain.type.exception.Failure
import com.konstload.chatmessanger.remote.core.Request
import com.konstload.chatmessanger.remote.service.ApiService
import javax.inject.Inject

/**
 * Класс, содержащий функции взаимодействия с аккаунтом в сети
 */
class AccountRemoteImpl @Inject constructor(
    private val request: Request,
    private val service: ApiService
) : AccountRemote {

    override fun register(
        email: String,
        name: String,
        password: String,
        token: String,
        userDate: Long
    ): Either<Failure, None> {
        return request.make(service.register(createRegisterMap(email, name, password, token, userDate))) { None() }
    }

    private fun createRegisterMap(
        email: String,
        name: String,
        password: String,
        token: String,
        userDate: Long
    ): Map<String, String> {
        val map = HashMap<String, String>()
        map[ApiService.PARAM_EMAIL] = email
        map[ApiService.PARAM_NAME] = name
        map[ApiService.PARAM_PASSWORD] = password
        map[ApiService.PARAM_TOKEN] = token
        map[ApiService.PARAM_USER_DATE] = userDate.toString()
        return map
    }
}
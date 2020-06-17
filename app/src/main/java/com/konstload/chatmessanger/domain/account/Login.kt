package com.konstload.chatmessanger.domain.account

import com.konstload.chatmessanger.domain.interactor.UseCase
import javax.inject.Inject
/**
 * Класс для авторизации
 */
class Login @Inject constructor(
    private val accountRepository: AccountRepository
) : UseCase<AccountEntity, Login.Params>() {
    override suspend fun run(params: Login.Params) =
        accountRepository.login(params.email, params.password)

    data class Params(val email: String, val password: String)
}
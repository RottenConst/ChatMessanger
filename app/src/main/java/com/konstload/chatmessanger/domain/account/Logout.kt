package com.konstload.chatmessanger.domain.account

import com.konstload.chatmessanger.domain.interactor.UseCase
import com.konstload.chatmessanger.domain.type.Either
import com.konstload.chatmessanger.domain.type.Failure
import com.konstload.chatmessanger.domain.type.None
import javax.inject.Inject

/**
 * Класс для выполнения выхода из аккаунта
 */
class Logout @Inject constructor(
    private val accountRepository: AccountRepository
) : UseCase<None, None>() {
    override suspend fun run(params: None): Either<Failure, None> = accountRepository.logout()
}
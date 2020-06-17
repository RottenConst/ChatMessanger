package com.konstload.chatmessanger.domain.account

import com.konstload.chatmessanger.domain.interactor.UseCase
import com.konstload.chatmessanger.domain.type.Either
import com.konstload.chatmessanger.domain.type.None
import com.konstload.chatmessanger.domain.type.Failure
import javax.inject.Inject

/**
 *UseCase класс для выполнения обновления токена
 */

class UpdateToken @Inject constructor(
    private val accountRepository: AccountRepository
) : UseCase<None, UpdateToken.Params>() {

    override suspend fun run(params: Params): Either<Failure, None> =
        accountRepository.updateAccountToken(params.token)

    /**
     * внутренний класс для передачи параметров
     */
    data class Params(val token: String)
}
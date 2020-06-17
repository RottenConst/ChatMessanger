package com.konstload.chatmessanger.domain.account

import com.konstload.chatmessanger.domain.interactor.UseCase
import com.konstload.chatmessanger.domain.type.Either
import com.konstload.chatmessanger.domain.type.None
import com.konstload.chatmessanger.domain.type.Failure
import javax.inject.Inject

/**
 * UseCase класс для выполнения регистрации
 */

class Register @Inject constructor(
    private val repository: AccountRepository
) : UseCase<None, Register.Params>() {

    override suspend fun run(params: Register.Params): Either<Failure, None> {
        return repository.register(params.email, params.name, params.password)
    }

    /**
     * внутренний класс для передачи параметров
     */
    data class Params(val email: String, val name: String, val password: String)
}
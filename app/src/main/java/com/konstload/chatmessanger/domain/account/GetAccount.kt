package com.konstload.chatmessanger.domain.account

import com.konstload.chatmessanger.domain.interactor.UseCase
import com.konstload.chatmessanger.domain.type.None
import javax.inject.Inject

/**
 * Класс для получения текущего аккаунта пользователя
 */
class GetAccount @Inject constructor(
    private val accountRepository: AccountRepository
) : UseCase<AccountEntity, None>() {
    override suspend fun run(params: None) = accountRepository.getCurrentAccount()
}
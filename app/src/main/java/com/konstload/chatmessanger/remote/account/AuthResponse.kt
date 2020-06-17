package com.konstload.chatmessanger.remote.account

import com.konstload.chatmessanger.domain.account.AccountEntity
import com.konstload.chatmessanger.remote.core.BaseResponse

/**
 * POJO-класс - для хранения ответа сервера при авторизации
 */
class AuthResponse(
    success: Int,
    message: String,
    val user: AccountEntity
) : BaseResponse(success, message)
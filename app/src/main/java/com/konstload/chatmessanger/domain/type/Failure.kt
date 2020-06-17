package com.konstload.chatmessanger.domain.type

/**
 * Base Class for handling errors/failures/exceptions.
 * Базовый класс для обработки ошибок /сбоев/ исключений.
 */

sealed class Failure {
    object NetworkConnectionError: Failure()
    object ServerError: Failure()
    object AuthError: Failure()
    object TokenError: Failure()

    object EmailAlreadyExistError: Failure()

    object NoSavedAccountsError: Failure()
}
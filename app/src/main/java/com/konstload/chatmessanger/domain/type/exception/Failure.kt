package com.konstload.chatmessanger.domain.type.exception

/**
 * Base Class for handling errors/failures/exceptions.
 * Базовый класс для обработки ошибок /сбоев/ исключений.
 */

sealed class Failure {
    object NetworkConnectionError: Failure()
    object ServerError: Failure()
}
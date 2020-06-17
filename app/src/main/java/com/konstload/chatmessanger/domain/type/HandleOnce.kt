package com.konstload.chatmessanger.domain.type

/**
 * Класс обертка - предотвращает повторное получение данных
 */
open class HandleOnce<out T> (val content: T){

    private var hasBeenHandled = false

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }
}
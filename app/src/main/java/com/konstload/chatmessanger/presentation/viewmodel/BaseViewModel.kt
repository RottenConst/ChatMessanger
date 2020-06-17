package com.konstload.chatmessanger.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.konstload.chatmessanger.domain.type.HandleOnce
import com.konstload.chatmessanger.domain.type.exception.Failure

/**
 * Базовый класс для выделения поведения всех ViewModel
 */
abstract class BaseViewModel : ViewModel() {
    val failureData: MutableLiveData<HandleOnce<Failure>> = MutableLiveData()

    protected fun handleFailure(failure: Failure) {
        this.failureData.value = HandleOnce(failure)
    }
}
package com.konstload.chatmessanger.remote.service

import com.konstload.chatmessanger.remote.core.BaseResponse
import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Интерфейс с функциями API, для формирования API запросов.
 * Содержит: вспомогательные константы с именем метода и параметрами, функцию для регистрации
 */
interface ApiService {
    companion object {
        //methods
        const val REGISTER = "register.php"

        //params
        const val PARAM_EMAIL = "email"
        const val PARAM_PASSWORD = "password"
        const val PARAM_NAME = "name"
        const val PARAM_TOKEN = "token"
        const val PARAM_USER_DATE = "user_date"
    }

    @FormUrlEncoded
    @POST(REGISTER)
    fun register(@FieldMap params: Map<String, String>): Call<BaseResponse>
}
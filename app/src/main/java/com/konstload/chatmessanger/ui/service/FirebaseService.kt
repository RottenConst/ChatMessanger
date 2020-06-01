package com.konstload.chatmessanger.ui.service

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.konstload.chatmessanger.domain.account.UpdateToken
import com.konstload.chatmessanger.ui.App
import javax.inject.Inject

/**
 * Сервис для получения сообщений и токена с Firebase
 */
class FirebaseService : FirebaseMessagingService() {

    @Inject
    lateinit var updateToken: UpdateToken

    override fun onCreate() {
        super.onCreate()
        App.appComponent.inject(this)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {

    }

    override fun onNewToken(token: String) {
        Log.e("fb token", ": $token")
        updateToken(UpdateToken.Params(token))
    }
}
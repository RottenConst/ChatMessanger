package com.konstload.chatmessanger.presentation.injection

import com.konstload.chatmessanger.BuildConfig
import com.konstload.chatmessanger.data.account.AccountRemote
import com.konstload.chatmessanger.remote.account.AccountRemoteImpl
import com.konstload.chatmessanger.remote.core.Request
import com.konstload.chatmessanger.remote.service.ApiService
import com.konstload.chatmessanger.remote.service.ServiceFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Класс модуль для предоставления зависимостей ApiService и AccountRemote
 */
@Module
class RemoteModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService = ServiceFactory.makeService(BuildConfig.DEBUG)

    @Singleton
    @Provides
    fun provideAccountRemote(request: Request, apiService: ApiService): AccountRemote {
        return AccountRemoteImpl(request, apiService)
    }
}
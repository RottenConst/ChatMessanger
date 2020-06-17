package com.konstload.chatmessanger.presentation.injection

import android.content.Context
import com.konstload.chatmessanger.data.account.AccountCache
import com.konstload.chatmessanger.data.account.AccountRemote
import com.konstload.chatmessanger.data.account.AccountRepositoryImpl
import com.konstload.chatmessanger.domain.account.AccountRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Класс-модуль для предоставления зависимостей контекста и репозитория
 */
@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideAppContext(): Context = context

    @Provides
    @Singleton
    fun provideAccountRepository(remote: AccountRemote, cache: AccountCache): AccountRepository {
        return AccountRepositoryImpl(remote, cache)
    }
}
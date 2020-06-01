package com.konstload.chatmessanger.presentation.injection

import android.accounts.AccountManager
import android.content.Context
import android.content.SharedPreferences
import com.konstload.chatmessanger.cache.AccountCacheImpl
import com.konstload.chatmessanger.cache.SharedPrefsManager
import com.konstload.chatmessanger.data.account.AccountCache
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Класс-модуль для предоставления зависимостей SharedPreferences и AccountCache.
 */
@Module
class CacheModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideAccountCache(prefsManager: SharedPrefsManager): AccountCache = AccountCacheImpl(prefsManager)
}
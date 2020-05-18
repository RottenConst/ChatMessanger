package com.konstload.chatmessanger.ui.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.konstload.chatmessanger.R
import com.konstload.chatmessanger.cache.AccountCacheImpl
import com.konstload.chatmessanger.cache.SharedPrefsManager
import com.konstload.chatmessanger.data.account.AccountRepositoryImpl
import com.konstload.chatmessanger.domain.account.AccountRepository
import com.konstload.chatmessanger.domain.account.Register
import com.konstload.chatmessanger.remote.account.AccountRemoteImpl
import com.konstload.chatmessanger.remote.core.NetworkHandler
import com.konstload.chatmessanger.remote.core.Request
import com.konstload.chatmessanger.remote.service.ServiceFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPrefs = this.getSharedPreferences(this.packageName, Context.MODE_PRIVATE)

        val accountCache = AccountCacheImpl(SharedPrefsManager(sharedPrefs))
        val accountRemote = AccountRemoteImpl(Request(NetworkHandler(this)), ServiceFactory.makeService(true))

        val accountRepository: AccountRepository = AccountRepositoryImpl(accountRemote, accountCache)

        accountCache.saveToken("12345")

        val register = Register(accountRepository)
        register(Register.Params("qwerty@m.com", "abcda", "123")) { it ->
            it.either({
                Toast.makeText(this, it.javaClass.simpleName, Toast.LENGTH_SHORT).show()
            }, {
                Toast.makeText(this, "Аккаунт создан", Toast.LENGTH_SHORT).show()
            })
        }
    }
}

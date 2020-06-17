package com.konstload.chatmessanger.ui

import android.app.Application
import com.konstload.chatmessanger.presentation.injection.AppModule
import com.konstload.chatmessanger.presentation.injection.CacheModule
import com.konstload.chatmessanger.presentation.injection.RemoteModule
import com.konstload.chatmessanger.presentation.injection.ViewModelModule
import com.konstload.chatmessanger.ui.activity.RegisterActivity
import com.konstload.chatmessanger.ui.fragment.RegisterFragment
import com.konstload.chatmessanger.ui.service.FirebaseService
import dagger.Component
import javax.inject.Singleton

/**
 * Класс приложения для инциализации компонентов приложения
 */
class App : Application() {

    companion object{
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        initAppComponent()
    }

    private fun initAppComponent(){
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this)).build()
    }
}

/**
 * Компонент для определения, в какие классы будут внедрятся зависимости:
 * (RegisterActivity, RegisterFragment, FirebaseService).
 * Использует модули для получения зависимостей: AppModule, CacheModule, RemoteModule, ViewModelModule.
 */
@Singleton
@Component(modules = [AppModule::class, CacheModule::class, RemoteModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(activity: RegisterActivity)

    fun inject(fragment: RegisterFragment)

    fun inject(service: FirebaseService)
}
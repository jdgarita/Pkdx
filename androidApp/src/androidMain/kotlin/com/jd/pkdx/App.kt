package com.jd.pkdx

import android.app.Application
import com.jd.pkdx.di.appModule
import com.jd.pkdx.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(networkModule, appModule)
        }
    }
}
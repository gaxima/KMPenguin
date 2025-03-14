package org.xima.penguinprojectkmp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.xima.penguinprojectkmp.di.initKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MyApplication)
        }
    }
}
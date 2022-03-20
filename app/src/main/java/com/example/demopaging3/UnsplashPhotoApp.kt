package com.example.demopaging3

import android.app.Application
import com.example.demopaging3.di.AppModule.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class UnsplashPhotoApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@UnsplashPhotoApp)
            modules(appModule)
        }
    }

}
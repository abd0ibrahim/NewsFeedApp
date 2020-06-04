package com.Link.newsapp

import android.app.Application
import com.Link.newsapp.network.mainModule
import org.koin.android.ext.android.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this,
            listOf(mainModule),
            loadPropertiesFromFile = true)
    }
}
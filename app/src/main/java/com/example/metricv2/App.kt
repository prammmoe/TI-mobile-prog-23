package com.example.metricv2

import android.app.Application
import com.example.metricv2.di.networkModule
import com.example.metricv2.di.repositoryModule
import com.example.metricv2.di.roomModule
import com.example.metricv2.di.viewModelModule
import com.intuit.sdp.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@App)
            modules(listOf(
                networkModule,
                repositoryModule,
                roomModule,
                viewModelModule
            ))
        }
    }
}
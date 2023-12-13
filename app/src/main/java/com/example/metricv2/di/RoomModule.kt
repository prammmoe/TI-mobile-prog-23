package com.example.metricv2.di

import androidx.room.Room
import com.example.metricv2.data.local.UserDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val roomModule = module {
    single {
        Room.databaseBuilder(androidContext(), UserDataBase::class.java, "userdb")
            .build()
    }
}
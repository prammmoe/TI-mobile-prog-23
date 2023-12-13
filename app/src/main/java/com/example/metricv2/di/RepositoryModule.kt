package com.example.metricv2.di

import com.example.metricv2.Repository
import com.example.metricv2.data.local.LocalRepository
import com.example.metricv2.data.remote.RemoteRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { LocalRepository(get()) }
    single { RemoteRepository(get()) }
    single { Repository(get(), get()) }
}
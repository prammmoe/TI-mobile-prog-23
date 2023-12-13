package com.example.metricv2.di

import com.example.metricv2.viewmodel.HomeViewModel
import com.example.metricv2.viewmodel.LoginViewModel
import com.example.metricv2.viewmodel.RegisterViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { LoginViewModel(get()) }
    single { RegisterViewModel(get()) }
    single { HomeViewModel(get()) }
}
package com.example.metricv2.di

import com.example.metricv2.viewmodel.LoginViewModel
import com.example.metricv2.viewmodel.RegisterViewModel
import com.example.metricv2.viewmodel.TrendsViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { LoginViewModel(get()) }
    single { RegisterViewModel(get()) }
    single { TrendsViewModel(get()) }
}
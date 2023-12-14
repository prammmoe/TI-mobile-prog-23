package com.example.metricv2.data.remote



class RemoteRepository(private val apiService: ApiService) {
    suspend fun getAllFood() = apiService.getAllFood("Seafood")
}
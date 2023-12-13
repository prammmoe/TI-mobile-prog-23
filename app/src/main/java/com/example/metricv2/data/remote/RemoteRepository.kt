package com.example.metricv2.data.remote

import com.example.metricv2.data.remote.response.Meal
import com.example.metricv2.data.remote.response.RandomFoodList
import retrofit2.Response

class RemoteRepository(private val apiService: ApiService) {
    suspend fun getRandomFood() = apiService.getRandomFood()
}
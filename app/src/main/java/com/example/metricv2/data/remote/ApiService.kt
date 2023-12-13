package com.example.metricv2.data.remote

import com.example.metricv2.data.remote.response.Meal
import com.example.metricv2.data.remote.response.RandomFoodList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.Response

interface ApiService {

    @GET("random.php")
    suspend fun getRandomFood(): Response<RandomFoodList>
}
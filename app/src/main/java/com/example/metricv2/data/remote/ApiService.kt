package com.example.metricv2.data.remote

import com.example.metricv2.data.remote.response.AllFoodList
import com.example.metricv2.data.remote.response.RandomFoodList
import retrofit2.http.GET
import retrofit2.Response
import retrofit2.http.Query

interface ApiService {

    @GET("random.php")
    suspend fun getRandomFood(): Response<RandomFoodList>
    
    @GET("filter.php?")
    suspend fun getAllFood(@Query("c") categoryName: String): Response<AllFoodList> 
}
package com.example.metricv2.retrofit

import com.example.metricv2.pojo.RandomFoodList
import retrofit2.http.GET
import retrofit2.Call

interface FoodApi {

    @GET("random.php")
    fun getRandomFood():Call<RandomFoodList>
}
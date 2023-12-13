package com.example.metricv2.data.remote.response


import com.google.gson.annotations.SerializedName

data class RandomFoodList(
    @SerializedName("meals")
    val meals: List<Meal>
)
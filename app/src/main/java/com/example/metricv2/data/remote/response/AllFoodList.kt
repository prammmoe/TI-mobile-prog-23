package com.example.metricv2.data.remote.response


import com.google.gson.annotations.SerializedName

data class AllFoodList(
    @SerializedName("meals")
    val meals: List<MealCategory>
)

data class MealCategory(
    @SerializedName("idMeal")
    val idMeal: String,
    @SerializedName("strMeal")
    val strMeal: String,
    @SerializedName("strMealThumb")
    val strMealThumb: String
)
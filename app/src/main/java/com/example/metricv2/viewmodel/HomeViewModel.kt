package com.example.metricv2.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.metricv2.pojo.Meal
import com.example.metricv2.pojo.RandomFoodList
import com.example.metricv2.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel():ViewModel() {
    private var randomFoodLiveData = MutableLiveData<Meal>()

    fun getRandomFood() {
        RetrofitInstance.api.getRandomFood().enqueue(object : Callback<RandomFoodList> {
            override fun onResponse(
                call: Call<RandomFoodList>,
                response: Response<RandomFoodList>
            ) {
                if(response.body() != null) {
                    val randomFood: Meal = response.body()!!.meals[0]
                    randomFoodLiveData.value = randomFood
                } else {
                    return
                }
            }

            override fun onFailure(call: Call<RandomFoodList>, t: Throwable) {
                Log.d("HomeFragment", t.message.toString())
            }
        })
    }

    fun observeRandomFoodLiveData():LiveData<Meal>{
        return randomFoodLiveData
    }
}
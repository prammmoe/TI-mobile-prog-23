package com.example.metricv2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.metricv2.Repository
import com.example.metricv2.data.remote.response.Meal
import com.example.metricv2.data.remote.response.RandomFoodList
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class HomeViewModel(private val repository: Repository): ViewModel() {

    private val getRandomFoods = MutableLiveData<Response<RandomFoodList>>()
    fun observeRandomFoodLiveData():LiveData<Response<RandomFoodList>>{
        return getRandomFoods
    }

    fun getRandomFoods() {
        viewModelScope.launch {
            try {
                val result = repository.getRandomFood()
                getRandomFoods.postValue(result)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }



//    private var randomFoodLiveData = MutableLiveData<Meal>()
//
//    fun getRandomFood() {
//        RetrofitInstance.api.getRandomFood().enqueue(object : Callback<RandomFoodList> {
//            override fun onResponse(
//                call: Call<RandomFoodList>,
//                response: Response<RandomFoodList>
//            ) {
//                if(response.body() != null) {
//                    val randomFood: Meal = response.body()!!.meals[0]
//                    randomFoodLiveData.value = randomFood
//                } else {
//                    return
//                }
//            }
//
//            override fun onFailure(call: Call<RandomFoodList>, t: Throwable) {
//                Log.d("HomeFragment", t.message.toString())
//            }
//        })
//    }
//
//    fun observeRandomFoodLiveData():LiveData<Meal>{
//        return randomFoodLiveData
//    }
}
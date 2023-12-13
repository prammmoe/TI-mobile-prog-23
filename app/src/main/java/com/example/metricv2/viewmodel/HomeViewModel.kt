package com.example.metricv2.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.metricv2.Repository
import com.example.metricv2.data.remote.response.Meal
import com.example.metricv2.data.remote.response.RandomFoodList
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import java.lang.Exception

class HomeViewModel(private val repository: Repository): ViewModel() {

    private val getRandomFoods = MutableLiveData<Response<RandomFoodList>>()

    fun observeRandomFoodLiveData(): LiveData<Response<RandomFoodList>> = getRandomFoods

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
}

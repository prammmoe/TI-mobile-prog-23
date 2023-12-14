package com.example.metricv2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.metricv2.Repository
import com.example.metricv2.data.remote.response.AllFoodList
import com.example.metricv2.data.remote.response.RandomFoodList
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class TrendsViewModel(private val repository: Repository): ViewModel() {
    private val getAllFoods = MutableLiveData<Response<AllFoodList>>()

    fun observeRandomFoodLiveData(): LiveData<Response<AllFoodList>> = getAllFoods

    fun getAllFoods() {
        viewModelScope.launch {
            try {
                val result = repository.getAllFood()
                getAllFoods.postValue(result)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
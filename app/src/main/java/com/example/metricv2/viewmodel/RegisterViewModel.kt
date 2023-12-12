package com.example.metricv2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.metricv2.data.UserDataBase
import com.example.metricv2.data.UserEntity
import com.example.metricv2.data.UserRepository
import kotlinx.coroutines.launch

class RegisterViewModel(application: Application) : AndroidViewModel(application) {
    private var repository : UserRepository
    private var getUserData : LiveData<List<UserEntity>>

    init {
        val userDao = UserDataBase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        getUserData = repository.getData
    }

    fun insertData(data : UserEntity) {
        viewModelScope.launch {
            repository.insertData(data)
        }
    }
}
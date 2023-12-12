package com.example.metricv2.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class UserRepository(application: Application) {

    private val userDao = UserDataBase.getDatabase(application).userDao()
    private val userData = userDao.getAllData().asLiveData()

    fun getUserData(): LiveData<List<UserEntity>> = userData

    fun insertData(data: UserEntity) {
        CoroutineScope(IO).launch {
            userDao.insertData(data) // Use Room's insert method directly
        }
    }

    fun insertAndObserve(data: UserEntity): LiveData<Long> { // Extension function for convenience
        return userDao.insert(data).asLiveData() // Combine insert and asLiveData
    }
}

//class UserRepository (application: Application) {
////    suspend fun insertData(user : UserEntity) {
////        userDao.insertData(user)
////    }
//
////    val getData : LiveData<List<UserEntity>> = userDao.getAllData()
//
//    private var userDao : UserDao? = null
//    private var userData: LiveData<List<UserEntity>>? = null
//
//    init {
//        val db = UserDataBase.getDatabase(application)
//        userDao = db?.userDao()
//        userData = userDao?.getAllData()
//    }
//
//    fun getUserData(): LiveData<List<UserEntity>>? {
//        return userData
//    }
//
//    fun insertData(data: UserEntity) {
//        userDao?.let { Login }
//    }
//
//    private class LoginInsertion(private val userDao: UserDao):
//        AsyncTask() {
//
//    }
//}
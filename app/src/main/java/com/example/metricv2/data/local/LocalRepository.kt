package com.example.metricv2.data.local

import com.example.metricv2.data.local.entity.UserEntity

class LocalRepository(private val userDataBase: UserDataBase) {
    suspend fun insertUser(userEntity: UserEntity) {
        userDataBase.userDao().insertUser(userEntity)
    }
    suspend fun getUser(email: String, password: String): UserEntity {
        return userDataBase.userDao().getUser(email, password)
    }
}
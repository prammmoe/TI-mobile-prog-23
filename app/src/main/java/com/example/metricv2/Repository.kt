package com.example.metricv2

import com.example.metricv2.data.local.LocalRepository
import com.example.metricv2.data.local.UserDataBase
import com.example.metricv2.data.local.entity.UserEntity
import com.example.metricv2.data.remote.RemoteRepository

class Repository(private val localRepository: LocalRepository, private val remoteRepository: RemoteRepository) {

    suspend fun insertUser(userEntity: UserEntity) {
        localRepository.insertUser(userEntity)
    }

    suspend fun getUser(email: String, password: String): UserEntity {
        return localRepository.getUser(email, password)
    }
    suspend fun getRandomFood() = remoteRepository.getRandomFood()

    suspend fun getAllFood() = remoteRepository.getAllFood()
}
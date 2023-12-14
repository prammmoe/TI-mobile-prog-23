package com.example.metricv2.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.metricv2.data.local.dao.UserDao
import com.example.metricv2.data.local.entity.UserEntity


@Database(entities = [UserEntity::class], version = 2, exportSchema = false)
abstract class  UserDataBase : RoomDatabase() {
    abstract fun userDao() : UserDao
}

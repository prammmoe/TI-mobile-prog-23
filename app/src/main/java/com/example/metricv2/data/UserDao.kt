package com.example.metricv2.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
//import retrofit2.http.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(user : UserEntity)

    @Query("SELECT * FROM user")
    fun getAllData() : LiveData<List<UserEntity>>
}
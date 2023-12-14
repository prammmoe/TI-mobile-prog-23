package com.example.metricv2.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name : String,
    val email : String,
    val password : String
)

package com.example.metricv2.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="user_id")
    val id : Int=0,
    @ColumnInfo(name="user_name")
    val name : String,
    @ColumnInfo(name="user_email")
    val email : String,
    @ColumnInfo(name="user_password")
    val password : String
)

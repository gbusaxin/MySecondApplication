package com.example.mysecondapplication.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "motivation_table")
data class MotivationDbModel(
    @PrimaryKey(autoGenerate = false)
    val author: String,
    val image: String,
    val message: String
)
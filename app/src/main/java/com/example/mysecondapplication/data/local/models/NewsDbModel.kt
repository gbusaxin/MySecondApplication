package com.example.mysecondapplication.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "news_table")
data class NewsDbModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title: String,
    val date: String,
    val image: String,
    val shortDescription: String,
    val description: String,
)
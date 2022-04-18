package com.example.mysecondapplication.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "nutrition_table")
data class NutritionDbModel(
    @PrimaryKey(autoGenerate = false)
    val title: String,
    val shortDesc: String,
    val backgroundImage: String,
    val date: String,
    val description: String,
)
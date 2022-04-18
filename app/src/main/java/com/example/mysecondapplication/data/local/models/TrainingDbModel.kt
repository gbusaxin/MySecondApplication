package com.example.mysecondapplication.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.mysecondapplication.data.local.converters.TrainingConverter
import com.example.mysecondapplication.domain.models.TrainingItem


@Entity(tableName = "training_table")
@TypeConverters(TrainingConverter::class)
data class TrainingDbModel(
    @PrimaryKey(autoGenerate = false)
    val trainer: String,
    val imageTrainer: String,
    val aboutTrainer: String,
    val training: List<TrainingItem>
)
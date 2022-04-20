package com.example.mysecondapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mysecondapplication.data.local.models.MotivationDbModel
import com.example.mysecondapplication.data.local.models.NewsDbModel
import com.example.mysecondapplication.data.local.models.NutritionDbModel
import com.example.mysecondapplication.data.local.models.TrainingDbModel

@Database(
    entities = [
        MotivationDbModel::class,
        NutritionDbModel::class,
        TrainingDbModel::class,
        NewsDbModel::class
    ],
    version = 5,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getFeaturedDao(): FeatureDao
    abstract fun getNewsDao(): NewsDao

}
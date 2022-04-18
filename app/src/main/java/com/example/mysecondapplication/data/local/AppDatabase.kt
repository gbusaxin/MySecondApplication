package com.example.mysecondapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mysecondapplication.data.local.models.MotivationDbModel
import com.example.mysecondapplication.data.local.models.NutritionDbModel
import com.example.mysecondapplication.data.local.models.TrainingDbModel

@Database(
    entities = [
        MotivationDbModel::class,
        NutritionDbModel::class,
        TrainingDbModel::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getFeaturedDao(): FeatureDao

}
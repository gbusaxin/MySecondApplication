package com.example.mysecondapplication.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mysecondapplication.data.local.models.MotivationDbModel
import com.example.mysecondapplication.data.local.models.NutritionDbModel
import com.example.mysecondapplication.data.local.models.TrainingDbModel

@Dao
interface FeatureDao {

    //Training operations
    @Query("SELECT * FROM training_table")
    fun getAllTrainings(): List<TrainingDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTrainings(list: List<TrainingDbModel>)

    @Query("SELECT * FROM training_table WHERE trainer =:trainer")
    suspend fun getSelectedTraining(trainer: String): TrainingDbModel

    //Motivation operations
    @Query("SELECT * FROM motivation_table")
    fun getAllMotivations(): List<MotivationDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMotivations(list: List<MotivationDbModel>)

    @Query("SELECT * FROM motivation_table WHERE author =:author")
    suspend fun getSelectedMotivation(author: String): MotivationDbModel

    //Nutrition operations
    @Query("SELECT * FROM nutrition_table")
    fun getAllNutrition(): List<NutritionDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllNutrition(list: List<NutritionDbModel>)

    @Query("SELECT * FROM nutrition_table WHERE title =:title")
    suspend fun getSelectedNutrition(title: String): NutritionDbModel

}
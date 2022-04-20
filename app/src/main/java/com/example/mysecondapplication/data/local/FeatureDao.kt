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

    @Query("SELECT * FROM training_table WHERE id =:id")
    suspend fun getSelectedTraining(id: Int): TrainingDbModel

    //Motivation operations
    @Query("SELECT * FROM motivation_table")
    fun getAllMotivations(): List<MotivationDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMotivations(list: List<MotivationDbModel>)

    @Query("SELECT * FROM motivation_table WHERE id =:id")
    suspend fun getSelectedMotivation(id: Int): MotivationDbModel

    //Nutrition operations
    @Query("SELECT * FROM nutrition_table")
    fun getAllNutrition(): List<NutritionDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllNutrition(list: List<NutritionDbModel>)

    @Query("SELECT * FROM nutrition_table WHERE id =:id")
    suspend fun getSelectedNutrition(id: Int): NutritionDbModel

    //delete operations
    @Query("DELETE FROM motivation_table")
    suspend fun deleteMotivation()

    @Query("DELETE FROM nutrition_table")
    suspend fun deleteNutrition()

    @Query("DELETE FROM training_table")
    suspend fun deleteTraining()

}
package com.example.mysecondapplication.domain.repository

import com.example.mysecondapplication.domain.models.Motivation
import com.example.mysecondapplication.domain.models.Nutrition
import com.example.mysecondapplication.domain.models.Training
import kotlinx.coroutines.flow.Flow

interface FeaturedRepository {

    //Motivation
    suspend fun loadAllMotivations()

    suspend fun getAllMotivations(): Flow<List<Motivation>>

    suspend fun getSelectedMotivation(id: Int): Motivation

    //Training
    suspend fun loadAllTrainings()

    suspend fun getAllTrainings(): Flow<List<Training>>

    suspend fun getSelectedTraining(id: Int): Training

    //Nutrition
    suspend fun loadAllNutrition()

    suspend fun getAllNutrition(): Flow<List<Nutrition>>

    suspend fun getSelectedNutrition(id: Int): Nutrition

    //delete
    suspend fun deleteAllFeatured()

}
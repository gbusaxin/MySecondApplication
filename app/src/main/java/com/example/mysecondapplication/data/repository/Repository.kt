package com.example.mysecondapplication.data.repository

import com.example.mysecondapplication.domain.models.Motivation
import com.example.mysecondapplication.domain.models.Nutrition
import com.example.mysecondapplication.domain.models.Training
import com.example.mysecondapplication.domain.repository.FeaturedRepository
import com.example.mysecondapplication.domain.repository.OnBoardingOperations
import com.example.mysecondapplication.domain.repository.ServerOrderOperation
import com.example.mysecondapplication.utils.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val onBoardingOperations: OnBoardingOperations,
    private val serverOrderOperation: ServerOrderOperation,
    private val featuredRepository: FeaturedRepository
) {

    fun getOnBoardingState(): Flow<Boolean> {
        return onBoardingOperations.getOnBoardingState()
    }

    suspend fun setOnBoardingState(completed: Boolean) {
        onBoardingOperations.setOnBoardingState(completed = completed)
    }

    fun getLocale(): String {
        return serverOrderOperation.getLocale()
    }

    suspend fun sendRequest(): Flow<DataState<String>> {
        return serverOrderOperation.sendRequest()
    }

    suspend fun loadAllFeatured() {
        with(featuredRepository) {
            loadAllMotivations()
            loadAllNutrition()
            loadAllTrainings()
        }
    }

    suspend fun getAllMotivations(): Flow<List<Motivation>> {
        return featuredRepository.getAllMotivations()
    }

    suspend fun getAllTrainings(): Flow<List<Training>> {
        return featuredRepository.getAllTrainings()
    }

    suspend fun getAllNutrition(): Flow<List<Nutrition>> {
        return featuredRepository.getAllNutrition()
    }

    suspend fun getSelectedMotivation(author: String): Motivation {
        return featuredRepository.getSelectedMotivation(author)
    }

    suspend fun getSelectedTraining(trainer: String): Training {
        return featuredRepository.getSelectedTraining(trainer)
    }

    suspend fun getSelectedNutrition(title: String): Nutrition {
        return featuredRepository.getSelectedNutrition(title)
    }
}

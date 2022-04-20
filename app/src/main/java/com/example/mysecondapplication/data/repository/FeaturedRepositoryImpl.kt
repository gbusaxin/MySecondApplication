package com.example.mysecondapplication.data.repository

import com.example.mysecondapplication.data.local.AppDatabase
import com.example.mysecondapplication.data.mappers.MotivationMapper
import com.example.mysecondapplication.data.mappers.NutritionMapper
import com.example.mysecondapplication.data.mappers.TrainingMapper
import com.example.mysecondapplication.data.remote.ApiService
import com.example.mysecondapplication.domain.models.Motivation
import com.example.mysecondapplication.domain.models.Nutrition
import com.example.mysecondapplication.domain.models.Training
import com.example.mysecondapplication.domain.repository.FeaturedRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FeaturedRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
    private val apiService: ApiService,
    private val nutritionMapper: NutritionMapper,
    private val motivationMapper: MotivationMapper,
    private val trainingMapper: TrainingMapper
) : FeaturedRepository {

    private val dao = database.getFeaturedDao()

    override suspend fun loadAllMotivations() {
        val dto = apiService.loadMotivations()
        val dbModel = dto.map { motivationMapper.mapDtoToDbModel(it) }
        dao.insertAllMotivations(dbModel)
    }

    override suspend fun getAllMotivations(): Flow<List<Motivation>> {
        return flow {
            val dbModel = dao.getAllMotivations()
            val entity = dbModel.map { motivationMapper.mapDbModelToEntity(it) }
            emit(entity)
        }
    }

    override suspend fun getSelectedMotivation(id: Int): Motivation {
        return motivationMapper.mapDbModelToEntity(dao.getSelectedMotivation(id = id))
    }

    override suspend fun loadAllTrainings() {
        val dto = apiService.loadTrainings()
        val dbModel = dto.map { trainingMapper.mapDtoToDbModel(it) }
        dao.insertAllTrainings(dbModel)
    }

    override suspend fun getAllTrainings(): Flow<List<Training>> {
        return flow {
            val dbModel = dao.getAllTrainings()
            val entity = dbModel.map { trainingMapper.mapDbModelToEntity(it) }
            emit(entity)
        }
    }

    override suspend fun getSelectedTraining(id: Int): Training {
        return trainingMapper.mapDbModelToEntity(dao.getSelectedTraining(id = id))
    }

    override suspend fun loadAllNutrition() {
        val dto = apiService.loadNutrition()
        val dbModel = dto.map { nutritionMapper.mapDtoToDbModel(it) }
        dao.insertAllNutrition(dbModel)
    }

    override suspend fun getAllNutrition(): Flow<List<Nutrition>> {
        return flow {
            val dbModel = dao.getAllNutrition()
            val entity = dbModel.map { nutritionMapper.mapDbModelToEntity(it) }
            emit(entity)
        }
    }

    override suspend fun getSelectedNutrition(id: Int): Nutrition {
        return nutritionMapper.mapDbModelToEntity(dao.getSelectedNutrition(id = id))
    }

    override suspend fun deleteAllFeatured() {
        with(dao) {
            deleteMotivation()
            deleteNutrition()
            deleteTraining()
        }
    }
}
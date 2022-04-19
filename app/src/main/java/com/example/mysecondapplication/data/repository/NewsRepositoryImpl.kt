package com.example.mysecondapplication.data.repository

import com.example.mysecondapplication.data.local.AppDatabase
import com.example.mysecondapplication.data.mappers.NewsMapper
import com.example.mysecondapplication.data.remote.ApiService
import com.example.mysecondapplication.domain.models.News
import com.example.mysecondapplication.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val database: AppDatabase,
    private val mapper: NewsMapper
) : NewsRepository {

    private val dao = database.getNewsDao()

    override suspend fun loadNews() {
        val dto = apiService.loadNews()
        val dbModel = dto.map { mapper.mapDtoToDbModel(it) }
        dao.insertAllNews(dbModel)
    }

    override suspend fun getAllNews(): Flow<List<News>> {
        return flow {
            val dbModel = dao.getAllNews()
            val entity = dbModel.map { mapper.mapDbModelToEntity(it) }
            emit(entity)
        }
    }

    override suspend fun getSelectedNews(id: Int): News {
        return mapper.mapDbModelToEntity(dao.getSelectedNews(id = id))
    }
}
package com.example.mysecondapplication.domain.repository

import com.example.mysecondapplication.domain.models.News
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun loadNews()

    suspend fun getAllNews(): Flow<List<News>>

    suspend fun getSelectedNews(id: Int): News

}
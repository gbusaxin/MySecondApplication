package com.example.mysecondapplication.domain.repository

import com.example.mysecondapplication.utils.DataState
import kotlinx.coroutines.flow.Flow

interface ServerOrderOperation {
    suspend fun sendRequest(): Flow<DataState<String>>

    fun getLocale(): String
}
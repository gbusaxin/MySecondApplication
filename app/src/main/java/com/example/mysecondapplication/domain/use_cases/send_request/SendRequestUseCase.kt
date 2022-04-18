package com.example.mysecondapplication.domain.use_cases.send_request

import com.example.mysecondapplication.data.repository.Repository
import com.example.mysecondapplication.utils.DataState
import kotlinx.coroutines.flow.Flow

class SendRequestUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke() : Flow<DataState<String>> = repository.sendRequest()
}
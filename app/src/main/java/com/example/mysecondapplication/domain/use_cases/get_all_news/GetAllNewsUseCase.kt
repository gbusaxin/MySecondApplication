package com.example.mysecondapplication.domain.use_cases.get_all_news

import com.example.mysecondapplication.data.repository.Repository

class GetAllNewsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke() = repository.getAllNews()
}
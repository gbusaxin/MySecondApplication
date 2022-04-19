package com.example.mysecondapplication.domain.use_cases.load_news

import com.example.mysecondapplication.data.repository.Repository

class LoadAllNewsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke() = repository.loadNews()
}
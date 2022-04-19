package com.example.mysecondapplication.domain.use_cases.get_selected_news

import com.example.mysecondapplication.data.repository.Repository

class GetSelectedNewsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(id: Int) = repository.getSelectedNews(id = id)
}
package com.example.mysecondapplication.domain.use_cases.get_selected_motivation

import com.example.mysecondapplication.data.repository.Repository

class GetSelectedMotivationUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(author: String) = repository.getSelectedMotivation(author)
}
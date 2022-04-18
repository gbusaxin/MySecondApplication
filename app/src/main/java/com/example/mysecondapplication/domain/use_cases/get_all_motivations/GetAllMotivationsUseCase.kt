package com.example.mysecondapplication.domain.use_cases.get_all_motivations

import com.example.mysecondapplication.data.repository.Repository

class GetAllMotivationsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke() = repository.getAllMotivations()
}
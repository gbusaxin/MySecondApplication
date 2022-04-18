package com.example.mysecondapplication.domain.use_cases.get_all_trainings

import com.example.mysecondapplication.data.repository.Repository

class GetAllTrainingsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke() = repository.getAllTrainings()
}
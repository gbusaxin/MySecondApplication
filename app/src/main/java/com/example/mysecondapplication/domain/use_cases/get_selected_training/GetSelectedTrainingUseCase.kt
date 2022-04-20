package com.example.mysecondapplication.domain.use_cases.get_selected_training

import com.example.mysecondapplication.data.repository.Repository

class GetSelectedTrainingUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(id: Int) = repository.getSelectedTraining(id)
}
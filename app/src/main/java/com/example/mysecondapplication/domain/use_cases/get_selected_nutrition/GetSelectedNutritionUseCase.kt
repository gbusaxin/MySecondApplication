package com.example.mysecondapplication.domain.use_cases.get_selected_nutrition

import com.example.mysecondapplication.data.repository.Repository

class GetSelectedNutritionUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(id: Int) = repository.getSelectedNutrition(id)
}
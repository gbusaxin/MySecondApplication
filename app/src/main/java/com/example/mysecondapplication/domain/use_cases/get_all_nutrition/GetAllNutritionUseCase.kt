package com.example.mysecondapplication.domain.use_cases.get_all_nutrition

import com.example.mysecondapplication.data.repository.Repository

class GetAllNutritionUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke() = repository.getAllNutrition()
}
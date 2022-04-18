package com.example.mysecondapplication.domain.use_cases.load_all_featured

import com.example.mysecondapplication.data.repository.Repository

class LoadAllFeaturedUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke() = repository.loadAllFeatured()
}
package com.example.mysecondapplication.domain.use_cases.delete_featured

import com.example.mysecondapplication.data.repository.Repository

class DeleteFeaturedUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke() = repository.deleteAllFeatured()
}
package com.example.mysecondapplication.domain.use_cases.set_on_boarding_state

import com.example.mysecondapplication.data.repository.Repository

class SetOnBoardingState(
    private val repository: Repository
) {
    suspend operator fun invoke(completed: Boolean) =
        repository.setOnBoardingState(completed = completed)
}
package com.example.mysecondapplication.domain.use_cases.get_on_boarding_state

import com.example.mysecondapplication.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetOnBoardingState(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Boolean> = repository.getOnBoardingState()
}
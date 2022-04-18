package com.example.mysecondapplication.domain.use_cases.get_locale

import com.example.mysecondapplication.data.repository.Repository

class GetLocaleUseCase(
    private val repository: Repository
) {
    operator fun invoke(): String = repository.getLocale()
}
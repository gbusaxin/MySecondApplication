package com.example.mysecondapplication.presentation.screens.nutrition

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mysecondapplication.domain.models.Nutrition
import com.example.mysecondapplication.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class NutritionViewModel @Inject constructor(
    useCases: UseCases
) : ViewModel() {

    private val _nutritionState =
        MutableStateFlow<List<Nutrition>>(value = Collections.emptyList())
    val motivationState: StateFlow<List<Nutrition>> = _nutritionState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.getAllNutritionUseCase().collect {
                _nutritionState.value = it
            }
        }
    }

}
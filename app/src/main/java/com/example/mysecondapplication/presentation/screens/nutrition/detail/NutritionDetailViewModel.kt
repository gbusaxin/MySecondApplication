package com.example.mysecondapplication.presentation.screens.nutrition.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mysecondapplication.domain.models.Nutrition
import com.example.mysecondapplication.domain.use_cases.UseCases
import com.example.mysecondapplication.navigation.ARGUMENT_NUTRITION_DETAIL_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NutritionDetailViewModel @Inject constructor(
    useCases: UseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _selectedNutritionState: MutableStateFlow<Nutrition?> = MutableStateFlow(null)
    val selectedNutritionState: StateFlow<Nutrition?> = _selectedNutritionState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val id = savedStateHandle.get<Int>(ARGUMENT_NUTRITION_DETAIL_KEY)
            _selectedNutritionState.value = id?.let { useCases.getSelectedNutritionUseCase(it) }
        }
    }

}
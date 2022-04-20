package com.example.mysecondapplication.presentation.screens.motivation.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mysecondapplication.domain.models.Motivation
import com.example.mysecondapplication.domain.use_cases.UseCases
import com.example.mysecondapplication.navigation.ARGUMENT_MOTIVATION_DETAIL_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MotivationDetailViewModel @Inject constructor(
    useCases: UseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _selectedMotivationState: MutableStateFlow<Motivation?> = MutableStateFlow(null)
    val selectedMotivationState: StateFlow<Motivation?> = _selectedMotivationState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val id = savedStateHandle.get<Int>(ARGUMENT_MOTIVATION_DETAIL_KEY)
            _selectedMotivationState.value = id?.let { useCases.getSelectedMotivationUseCase(it) }
        }
    }
}
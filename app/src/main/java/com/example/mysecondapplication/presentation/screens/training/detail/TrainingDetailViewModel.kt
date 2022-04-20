package com.example.mysecondapplication.presentation.screens.training.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mysecondapplication.domain.models.Training
import com.example.mysecondapplication.domain.use_cases.UseCases
import com.example.mysecondapplication.navigation.ARGUMENT_TRAINING_DETAIL_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrainingDetailViewModel @Inject constructor(
    useCases: UseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _selectedTrainingState: MutableStateFlow<Training?> = MutableStateFlow(null)
    val selectedTrainingState: StateFlow<Training?> = _selectedTrainingState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val id = savedStateHandle.get<Int>(ARGUMENT_TRAINING_DETAIL_KEY)
            _selectedTrainingState.value = id?.let { useCases.getSelectedTrainingUseCase(it) }
        }
    }

}
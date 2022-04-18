package com.example.mysecondapplication.presentation.screens.motivation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mysecondapplication.domain.models.Motivation
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
class MotivationViewModel @Inject constructor(
    useCases: UseCases
) : ViewModel() {

    private val _motivationState =
        MutableStateFlow<List<Motivation>>(value = Collections.emptyList())
    val motivationState: StateFlow<List<Motivation>> = _motivationState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.getAllMotivationsUseCase().collect {
                _motivationState.value = it
            }
        }
    }
}
package com.example.mysecondapplication.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mysecondapplication.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    useCases: UseCases
) : ViewModel() {


    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.deleteFeaturedUseCase()
            useCases.loadAllFeaturedUseCase()
        }
    }
}
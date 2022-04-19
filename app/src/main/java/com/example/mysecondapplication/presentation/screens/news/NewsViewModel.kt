package com.example.mysecondapplication.presentation.screens.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mysecondapplication.domain.models.News
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
class NewsViewModel @Inject constructor(
    useCases: UseCases
) : ViewModel() {

    private val _newsState =
        MutableStateFlow<List<News>>(value = Collections.emptyList())
    val newsState: StateFlow<List<News>> = _newsState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.loadAllNewsUseCase()
            useCases.getAllNewsUseCase().collect {
                _newsState.value = it
            }
        }
    }

}
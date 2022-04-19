package com.example.mysecondapplication.presentation.screens.news.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mysecondapplication.domain.models.News
import com.example.mysecondapplication.domain.use_cases.UseCases
import com.example.mysecondapplication.navigation.ARGUMENT_NEWS_DETAIL_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsDetailViewModel @Inject constructor(
    useCases: UseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _selectedNewsState: MutableStateFlow<News?> = MutableStateFlow(null)
    val selectedNewsState: StateFlow<News?> = _selectedNewsState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val id = savedStateHandle.get<Int>(ARGUMENT_NEWS_DETAIL_KEY)
            _selectedNewsState.value = id?.let { useCases.getSelectedNewsUseCase(it) }
        }
    }


}
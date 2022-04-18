package com.example.mysecondapplication.presentation.screens.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mysecondapplication.domain.use_cases.UseCases
import com.example.mysecondapplication.utils.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _onBoardingCompleted = MutableStateFlow(false)
    val onBoardingCompleted: StateFlow<Boolean> = _onBoardingCompleted

    private val _serverResponse: MutableStateFlow<DataState<String?>?> =
        MutableStateFlow(null)
    val serverResponse: StateFlow<DataState<String?>?> = _serverResponse

    private fun setStateEvent(stateEvent: ServerStateEvent) {
        viewModelScope.launch(Dispatchers.IO) {
            when (stateEvent) {
                is ServerStateEvent.GetServerResponse -> {
                    useCases.sendRequestUseCase().onEach { dataState ->
                        Log.d("CHECK_STATE",dataState.toString())
                        _serverResponse.value = dataState
                    }.launchIn(viewModelScope)
                }
                ServerStateEvent.ServerFailure -> {
                    throw Exception(
                        "Problem with ${this@SplashViewModel::class.java.simpleName} - ServerStateEvent == ServerFailure."
                    )
                }
            }
        }
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            setStateEvent(ServerStateEvent.GetServerResponse)
            _onBoardingCompleted.value =
                useCases.getOnBoardingState().stateIn(viewModelScope).value
        }
    }

}

sealed class ServerStateEvent {
    object GetServerResponse : ServerStateEvent()
    object ServerFailure : ServerStateEvent()
}
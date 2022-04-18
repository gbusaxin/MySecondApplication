package com.example.mysecondapplication.presentation.screens.chrome

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mysecondapplication.navigation.ARGUMENT_RESPONSE_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.net.URLDecoder
import java.nio.charset.StandardCharsets
import javax.inject.Inject

@HiltViewModel
class ChromeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _linkResponse: MutableStateFlow<String?> = MutableStateFlow(value = null)
    val linkResponse: StateFlow<String?> = _linkResponse

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val key = savedStateHandle.get<String>(ARGUMENT_RESPONSE_KEY)
            val decodedKey = URLDecoder.decode(key, StandardCharsets.UTF_8.toString())
            Log.d("DECODED_RESPONSE", decodedKey)
            _linkResponse.value = decodedKey
        }
    }
}
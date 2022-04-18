package com.example.mysecondapplication.data.remote.models

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class ResponseDto(
    @SerialName("url")
    var url: String
)
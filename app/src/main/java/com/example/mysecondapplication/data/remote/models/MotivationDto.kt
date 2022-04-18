package com.example.mysecondapplication.data.remote.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class MotivationDto(
    @SerializedName("author")
    @Expose
    val author: String? = null,
    @SerializedName("image")
    @Expose
    val image: String? = null,
    @SerializedName("message")
    @Expose
    val message: String? = null
)
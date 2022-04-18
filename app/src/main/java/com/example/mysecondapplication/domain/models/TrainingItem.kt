package com.example.mysecondapplication.domain.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class TrainingItem(
    @SerializedName("title")
    @Expose
    val title: String? = null,
    @SerializedName("exercise")
    @Expose
    val exercise: String? = null,
    @SerializedName("image")
    @Expose
    val image: String? = null
)


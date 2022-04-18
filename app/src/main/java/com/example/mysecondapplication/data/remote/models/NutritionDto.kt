package com.example.mysecondapplication.data.remote.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class NutritionDto(
    @SerializedName("title")
    @Expose
    val title: String?,
    @SerializedName("shortDesc")
    @Expose
    val shortDesc: String?,
    @SerializedName("backgroundImage")
    @Expose
    val backgroundImage: String?,
    @SerializedName("date")
    @Expose
    val date: String?,
    @SerializedName("description")
    @Expose
    val description: String?,
)
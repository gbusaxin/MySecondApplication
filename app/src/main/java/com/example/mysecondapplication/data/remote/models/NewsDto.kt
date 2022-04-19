package com.example.mysecondapplication.data.remote.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class NewsDto(
    @SerializedName("title")
    @Expose
    val title: String? = null,
    @SerializedName("date")
    @Expose
    val date: String? = null,
    @SerializedName("image")
    @Expose
    val image: String? = null,
    @SerializedName("shortDescription")
    @Expose
    val shortDescription: String? = null,
    @SerializedName("description")
    @Expose
    val description: String? = null
)
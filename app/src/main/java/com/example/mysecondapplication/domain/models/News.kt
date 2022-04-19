package com.example.mysecondapplication.domain.models


data class News(
    val id:Int,
    val title: String,
    val date: String,
    val image: String,
    val shortDescription: String,
    val description: String
)
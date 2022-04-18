package com.example.mysecondapplication.domain.models


data class Training(
    val trainer: String,
    val imageTrainer: String,
    val aboutTrainer: String,
    val trainingList: List<TrainingItem>
)
package com.example.mysecondapplication.data.remote.models

import com.example.mysecondapplication.domain.models.TrainingItem
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class TrainingDto(
    @SerializedName("trainer")
    @Expose
    val trainer: String? = null,
    @SerializedName("imageTrainer")
    @Expose
    val imageTrainer: String? = null,
    @SerializedName("aboutTrainer")
    @Expose
    val aboutTrainer: String? = null,
    @SerializedName("training")
    @Expose
    val training: List<TrainingItem>? = null
)
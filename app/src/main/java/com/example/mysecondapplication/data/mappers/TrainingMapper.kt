package com.example.mysecondapplication.data.mappers

import com.example.mysecondapplication.data.local.models.TrainingDbModel
import com.example.mysecondapplication.data.remote.models.TrainingDto
import com.example.mysecondapplication.domain.models.Training
import java.util.*
import javax.inject.Inject

class TrainingMapper @Inject constructor() {

    fun mapDbModelToEntity(dbModel: TrainingDbModel) = Training(
        trainer = dbModel.trainer,
        imageTrainer = dbModel.imageTrainer,
        aboutTrainer = dbModel.aboutTrainer,
        trainingList = dbModel.training
    )

    fun mapDtoToDbModel(dto: TrainingDto) = TrainingDbModel(
        trainer = dto.trainer ?: "",
        imageTrainer = dto.imageTrainer ?: "",
        aboutTrainer = dto.aboutTrainer ?: "",
        training = dto.training ?: Collections.emptyList()
    )

}
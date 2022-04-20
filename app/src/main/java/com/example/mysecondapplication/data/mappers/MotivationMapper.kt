package com.example.mysecondapplication.data.mappers

import com.example.mysecondapplication.data.local.models.MotivationDbModel
import com.example.mysecondapplication.data.remote.models.MotivationDto
import com.example.mysecondapplication.domain.models.Motivation
import javax.inject.Inject

class MotivationMapper @Inject constructor() {

    fun mapDbModelToEntity(dbModel: MotivationDbModel) = Motivation(
        id = dbModel.id,
        author = dbModel.author,
        image = dbModel.image,
        message = dbModel.message
    )

    fun mapDtoToDbModel(dto: MotivationDto) = MotivationDbModel(
        id = 0,
        author = dto.author ?: "",
        image = dto.image ?: "",
        message = dto.message ?: ""
    )

}
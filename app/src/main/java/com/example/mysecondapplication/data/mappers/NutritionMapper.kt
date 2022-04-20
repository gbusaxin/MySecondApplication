package com.example.mysecondapplication.data.mappers

import com.example.mysecondapplication.data.local.models.NutritionDbModel
import com.example.mysecondapplication.data.remote.models.NutritionDto
import com.example.mysecondapplication.domain.models.Nutrition
import javax.inject.Inject

class NutritionMapper @Inject constructor() {
    fun mapDbModelToEntity(dbModel: NutritionDbModel) = Nutrition(
        id = dbModel.id,
        title = dbModel.title,
        shortDesc = dbModel.shortDesc,
        backgroundImage = dbModel.backgroundImage,
        date = dbModel.date,
        description = dbModel.description
    )

    fun mapDtoToDbModel(dto: NutritionDto) = NutritionDbModel(
        id = 0,
        title = dto.title ?: "",
        shortDesc = dto.shortDesc ?: "",
        backgroundImage = dto.backgroundImage ?: "",
        date = dto.date ?: "",
        description = dto.description ?: ""
    )
}
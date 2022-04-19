package com.example.mysecondapplication.data.mappers

import com.example.mysecondapplication.data.local.models.NewsDbModel
import com.example.mysecondapplication.data.remote.models.NewsDto
import com.example.mysecondapplication.domain.models.News
import javax.inject.Inject

class NewsMapper @Inject constructor() {

    fun mapDbModelToEntity(dbModel: NewsDbModel) = News(
        id = dbModel.id,
        title = dbModel.title,
        date = dbModel.date,
        image = dbModel.image,
        shortDescription = dbModel.shortDescription,
        description = dbModel.description
    )

    fun mapDtoToDbModel(dto: NewsDto) = NewsDbModel(
        id = 0,
        title = dto.title ?: "",
        date = dto.date ?: "",
        image = dto.image ?: "",
        shortDescription = dto.shortDescription ?: "",
        description = dto.description ?: ""
    )

}
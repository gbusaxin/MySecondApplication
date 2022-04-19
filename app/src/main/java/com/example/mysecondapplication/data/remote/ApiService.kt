package com.example.mysecondapplication.data.remote

import com.example.mysecondapplication.data.remote.models.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("/second_app/response/splash.php")
    suspend fun sendRequest(@Body locale: RequestDto): ResponseDto

    @GET("/second_app/let_motivation.json")
    suspend fun loadMotivations(): List<MotivationDto>

    @GET("/second_app/let_nutrition.json")
    suspend fun loadNutrition(): List<NutritionDto>

    @GET("/second_app/let_training.json")
    suspend fun loadTrainings(): List<TrainingDto>

    @GET("/second_app/sport_news.json")
    suspend fun loadNews(): List<NewsDto>
}
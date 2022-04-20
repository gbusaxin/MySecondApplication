package com.example.mysecondapplication.domain.use_cases

import com.example.mysecondapplication.domain.use_cases.delete_featured.DeleteFeaturedUseCase
import com.example.mysecondapplication.domain.use_cases.get_all_motivations.GetAllMotivationsUseCase
import com.example.mysecondapplication.domain.use_cases.get_all_news.GetAllNewsUseCase
import com.example.mysecondapplication.domain.use_cases.get_all_nutrition.GetAllNutritionUseCase
import com.example.mysecondapplication.domain.use_cases.get_all_trainings.GetAllTrainingsUseCase
import com.example.mysecondapplication.domain.use_cases.get_locale.GetLocaleUseCase
import com.example.mysecondapplication.domain.use_cases.get_on_boarding_state.GetOnBoardingState
import com.example.mysecondapplication.domain.use_cases.get_selected_motivation.GetSelectedMotivationUseCase
import com.example.mysecondapplication.domain.use_cases.get_selected_news.GetSelectedNewsUseCase
import com.example.mysecondapplication.domain.use_cases.get_selected_nutrition.GetSelectedNutritionUseCase
import com.example.mysecondapplication.domain.use_cases.get_selected_training.GetSelectedTrainingUseCase
import com.example.mysecondapplication.domain.use_cases.load_all_featured.LoadAllFeaturedUseCase
import com.example.mysecondapplication.domain.use_cases.load_news.LoadAllNewsUseCase
import com.example.mysecondapplication.domain.use_cases.send_request.SendRequestUseCase
import com.example.mysecondapplication.domain.use_cases.set_on_boarding_state.SetOnBoardingState

data class UseCases(
    val getOnBoardingState: GetOnBoardingState,
    val setOnBoardingState: SetOnBoardingState,
    val getLocaleUseCase: GetLocaleUseCase,
    val sendRequestUseCase: SendRequestUseCase,
    val loadAllFeaturedUseCase: LoadAllFeaturedUseCase,
    val getAllMotivationsUseCase: GetAllMotivationsUseCase,
    val getAllNutritionUseCase: GetAllNutritionUseCase,
    val getAllTrainingsUseCase: GetAllTrainingsUseCase,
    val getSelectedMotivationUseCase: GetSelectedMotivationUseCase,
    val getSelectedNutritionUseCase: GetSelectedNutritionUseCase,
    val getSelectedTrainingUseCase: GetSelectedTrainingUseCase,
    val loadAllNewsUseCase: LoadAllNewsUseCase,
    val getSelectedNewsUseCase: GetSelectedNewsUseCase,
    val getAllNewsUseCase: GetAllNewsUseCase,
    val deleteFeaturedUseCase: DeleteFeaturedUseCase
)

package com.example.mysecondapplication.di

import android.content.Context
import com.example.mysecondapplication.data.local.AppDatabase
import com.example.mysecondapplication.data.mappers.MotivationMapper
import com.example.mysecondapplication.data.mappers.NewsMapper
import com.example.mysecondapplication.data.mappers.NutritionMapper
import com.example.mysecondapplication.data.mappers.TrainingMapper
import com.example.mysecondapplication.data.remote.ApiService
import com.example.mysecondapplication.data.repository.*
import com.example.mysecondapplication.domain.repository.FeaturedRepository
import com.example.mysecondapplication.domain.repository.NewsRepository
import com.example.mysecondapplication.domain.repository.OnBoardingOperations
import com.example.mysecondapplication.domain.repository.ServerOrderOperation
import com.example.mysecondapplication.domain.use_cases.UseCases
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
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideOnBoardingOperations(
        @ApplicationContext context: Context
    ): OnBoardingOperations {
        return OnBoardingOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideServerOrderOperation(
        apiService: ApiService
    ): ServerOrderOperation {
        return ServerOrderOperationImpl(apiService = apiService)
    }

    @Provides
    @Singleton
    fun provideFeaturedRepository(
        database: AppDatabase,
        apiService: ApiService,
        tMapper: TrainingMapper,
        mMapper: MotivationMapper,
        nMapper: NutritionMapper
    ): FeaturedRepository {
        return FeaturedRepositoryImpl(
            database = database,
            apiService = apiService,
            trainingMapper = tMapper,
            motivationMapper = mMapper,
            nutritionMapper = nMapper
        )
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        apiService: ApiService,
        database: AppDatabase,
        newsMapper: NewsMapper
    ): NewsRepository {
        return NewsRepositoryImpl(
            apiService = apiService,
            database = database,
            mapper = newsMapper
        )
    }

    @Provides
    @Singleton
    fun provideUseCases(
        repository: Repository
    ): UseCases {
        return UseCases(
            getOnBoardingState = GetOnBoardingState(repository = repository),
            setOnBoardingState = SetOnBoardingState(repository = repository),
            getLocaleUseCase = GetLocaleUseCase(repository = repository),
            sendRequestUseCase = SendRequestUseCase(repository = repository),
            loadAllFeaturedUseCase = LoadAllFeaturedUseCase(repository = repository),
            getAllMotivationsUseCase = GetAllMotivationsUseCase(repository = repository),
            getAllNutritionUseCase = GetAllNutritionUseCase(repository = repository),
            getAllTrainingsUseCase = GetAllTrainingsUseCase(repository = repository),
            getSelectedMotivationUseCase = GetSelectedMotivationUseCase(repository = repository),
            getSelectedNutritionUseCase = GetSelectedNutritionUseCase(repository = repository),
            getSelectedTrainingUseCase = GetSelectedTrainingUseCase(repository = repository),
            loadAllNewsUseCase = LoadAllNewsUseCase(repository = repository),
            getSelectedNewsUseCase = GetSelectedNewsUseCase(repository = repository),
            getAllNewsUseCase = GetAllNewsUseCase(repository = repository),
            deleteFeaturedUseCase = DeleteFeaturedUseCase(repository = repository)
        )
    }

}
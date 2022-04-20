package com.example.mysecondapplication.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.example.mysecondapplication.presentation.screens.chrome.ChromeScreen
import com.example.mysecondapplication.presentation.screens.home.HomeScreen
import com.example.mysecondapplication.presentation.screens.motivation.MotivationScreen
import com.example.mysecondapplication.presentation.screens.motivation.detail.MotivationDetailScreen
import com.example.mysecondapplication.presentation.screens.news.NewsScreen
import com.example.mysecondapplication.presentation.screens.news.detail.NewsDetailScreen
import com.example.mysecondapplication.presentation.screens.nutrition.NutritionScreen
import com.example.mysecondapplication.presentation.screens.nutrition.detail.NutritionDetailScreen
import com.example.mysecondapplication.presentation.screens.splash.SplashScreen
import com.example.mysecondapplication.presentation.screens.training.TrainingScreen
import com.example.mysecondapplication.presentation.screens.training.detail.TrainingDetailScreen
import com.example.mysecondapplication.presentation.screens.welcome.WelcomeScreen
import com.google.accompanist.pager.ExperimentalPagerApi


@ExperimentalFoundationApi
@ExperimentalPagerApi
@ExperimentalAnimationApi
@ExperimentalCoilApi
@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        composable(
            route = Screens.Splash.route
        ) {
            SplashScreen(navController = navController)
        }
        composable(
            route = Screens.Welcome.route
        ) {
            WelcomeScreen(navController = navController)
        }
        composable(
            route = Screens.Home.route
        ) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screens.Chrome.route,
            arguments = listOf(navArgument(ARGUMENT_RESPONSE_KEY) {
                type = NavType.StringType
            })
        ) {
            ChromeScreen(navController = navController)
        }
        composable(
            route = Screens.Nutrition.route
        ) {
            NutritionScreen(navController = navController)
        }
        composable(
            route = Screens.Motivation.route
        ) {
            MotivationScreen(navController = navController)
        }
        composable(
            route = Screens.Training.route
        ) {
            TrainingScreen(navController = navController)
        }
        composable(
            route = Screens.News.route
        ) {
            NewsScreen(navController = navController)
        }
        composable(
            route = Screens.NewsDetail.route,
            arguments = listOf(navArgument(ARGUMENT_NEWS_DETAIL_KEY) {
                type = NavType.IntType
            })
        ) {
            NewsDetailScreen(navController = navController)
        }
        composable(
            route = Screens.TrainingDetail.route,
            arguments = listOf(navArgument(ARGUMENT_TRAINING_DETAIL_KEY) {
                type = NavType.IntType
            })
        ) {
            TrainingDetailScreen(navController = navController)
        }
        composable(
            route = Screens.MotivationDetail.route,
            arguments = listOf(navArgument(ARGUMENT_MOTIVATION_DETAIL_KEY) {
                type = NavType.IntType
            })
        ) {
            MotivationDetailScreen(navController = navController)
        }
        composable(
            route = Screens.NutritionDetail.route,
            arguments = listOf(navArgument(ARGUMENT_NUTRITION_DETAIL_KEY) {
                type = NavType.IntType
            })
        ) {
            NutritionDetailScreen(navController = navController)
        }
    }
}
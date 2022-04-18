package com.example.mysecondapplication.utils

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.mysecondapplication.R
import com.example.mysecondapplication.ui.theme.*

//typealias ComposableFun = @Composable () -> Unit

sealed class FeaturedItems(
    val title: String,
    @DrawableRes val icon: Int,
    val lightColor: Color,
    val darkColor: Color,
    val route: String
) {

    object Motivation : FeaturedItems(
        title = "Мотивация",
        icon = R.drawable.ic_celebration,
        lightColor = Red1,
        darkColor = Red2,
        route = "motivation_screen"
    )

    object Nutrition : FeaturedItems(
        title = "Питание",
        icon = R.drawable.ic_food,
        lightColor = Blue1,
        darkColor = Blue2,
        route = "nutrition_screen"
    )

    object Training : FeaturedItems(
        title = "Тренировки",
        icon = R.drawable.ic_fitness,
        lightColor = Yellow1,
        darkColor = Yellow2,
        route = "training_screen"
    )

}

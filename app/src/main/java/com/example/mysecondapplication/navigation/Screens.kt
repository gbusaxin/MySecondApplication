package com.example.mysecondapplication.navigation

const val ARGUMENT_RESPONSE_KEY = "server_response"
const val ARGUMENT_NEWS_DETAIL_KEY = "news_detail"
const val ARGUMENT_MOTIVATION_DETAIL_KEY = "motivation_detail"
const val ARGUMENT_TRAINING_DETAIL_KEY = "training_detail"
const val ARGUMENT_NUTRITION_DETAIL_KEY = "nutrition_detail"

sealed class Screens(
    val route: String
) {
    object Splash : Screens(route = "splash_screen")

    object Welcome : Screens(route = "welcome_screen")

    object Home : Screens(route = "home_screen")

    object Chrome : Screens(route = "chrome_screen/{$ARGUMENT_RESPONSE_KEY}") {
        fun passResponse(route: String): String {
            return this.route.replace(oldValue = "{$ARGUMENT_RESPONSE_KEY}", newValue = route)
        }
    }

    object News : Screens(route = "news_screen")

    object NewsDetail : Screens(route = "news_screen/{$ARGUMENT_NEWS_DETAIL_KEY}") {
        fun passDetail(id: Int): String {
            return this.route.replace(
                oldValue = "{$ARGUMENT_NEWS_DETAIL_KEY}",
                newValue = id.toString()
            )
        }
    }

    object Motivation : Screens(route = "motivation_screen")

    object MotivationDetail :
        Screens(route = "motivation_screen/{$ARGUMENT_MOTIVATION_DETAIL_KEY}") {
        fun passDetail(id: Int): String {
            return this.route.replace(
                oldValue = "{$ARGUMENT_MOTIVATION_DETAIL_KEY}",
                newValue = id.toString()
            )
        }
    }

    object Training : Screens(route = "training_screen")

    object TrainingDetail : Screens(route = "training_screen/{$ARGUMENT_TRAINING_DETAIL_KEY}") {
        fun passDetail(id: Int): String {
            return this.route.replace(
                oldValue = "{$ARGUMENT_TRAINING_DETAIL_KEY}",
                newValue = id.toString()
            )
        }
    }

    object Nutrition : Screens(route = "nutrition_screen")

    object NutritionDetail : Screens(route = "nutrition_screen/{$ARGUMENT_NUTRITION_DETAIL_KEY}") {
        fun passDetail(id: Int): String {
            return this.route.replace(
                oldValue = "{$ARGUMENT_NUTRITION_DETAIL_KEY}",
                newValue = id.toString()
            )
        }
    }
}

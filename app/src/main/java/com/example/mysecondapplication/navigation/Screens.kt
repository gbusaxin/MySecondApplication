package com.example.mysecondapplication.navigation

const val ARGUMENT_RESPONSE_KEY = "server_response"
const val ARGUMENT_NEWS_DETAIL_KEY = "news_detail"

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
            return this.route.replace(oldValue = "{$ARGUMENT_NEWS_DETAIL_KEY}", newValue = id.toString())
        }
    }

    object Motivation : Screens(route = "motivation_screen")

    object Training : Screens(route = "training_screen")

    object Nutrition : Screens(route = "nutrition_screen")
}

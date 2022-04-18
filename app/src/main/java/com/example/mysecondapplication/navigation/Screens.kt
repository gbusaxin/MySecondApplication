package com.example.mysecondapplication.navigation

const val ARGUMENT_RESPONSE_KEY = "server_response"

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

    object Motivation : Screens(route = "motivation_screen")

    object Training : Screens(route = "training_screen")

    object Nutrition : Screens(route = "nutrition_screen")
}

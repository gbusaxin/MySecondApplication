package com.example.mysecondapplication.utils

import androidx.annotation.DrawableRes
import com.example.mysecondapplication.R

sealed class OnBoardingPages(
    @DrawableRes
    val image: Int,
    val title: String,
) {

    object StartPage : OnBoardingPages(
        image = R.drawable.ic_hand,
        title = "Добро пожаловать!"
    )

    object LastPage : OnBoardingPages(
        image = R.drawable.ic_downward,
        title = "Нажмите кнопку для того чтобы продолжить..."
    )
}
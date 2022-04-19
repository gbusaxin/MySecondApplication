package com.example.mysecondapplication.presentation.screens.news

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.example.mysecondapplication.navigation.Screens
import com.example.mysecondapplication.presentation.common.FeaturedItemContainer
import com.example.mysecondapplication.presentation.components.BackStackAppBar
import com.example.mysecondapplication.ui.theme.DarkOrange
import com.example.mysecondapplication.ui.theme.LightOrange
import com.example.mysecondapplication.ui.theme.SMALL_PADDING
import com.example.mysecondapplication.ui.theme.mainBackgroundColor

@ExperimentalCoilApi
@Composable
fun NewsScreen(
    navController: NavHostController,
    viewModel: NewsViewModel = hiltViewModel()
) {

    val list by viewModel.newsState.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        BackStackAppBar(
            navController = navController
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.mainBackgroundColor),
            contentPadding = PaddingValues(start = SMALL_PADDING, end = SMALL_PADDING),
            verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
        ) {
            items(
                items = list,
                key = { news -> news.title }
            ) {
                it?.let { news ->
                    FeaturedItemContainer(
                        navController = navController,
                        image = news.image,
                        title = news.title,
                        description = news.shortDescription,
                        lightColor = LightOrange,
                        darkColor = DarkOrange,
                        route = Screens.NewsDetail.passDetail(news.id)
                    )
                }
            }
        }
    }

}
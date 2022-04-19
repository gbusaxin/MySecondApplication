package com.example.mysecondapplication.presentation.screens.motivation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.mysecondapplication.ui.theme.Red1
import com.example.mysecondapplication.ui.theme.Red2
import com.example.mysecondapplication.ui.theme.SMALL_PADDING

@ExperimentalCoilApi
@Composable
fun MotivationScreen(
    navController: NavHostController,
    viewModel: MotivationViewModel = hiltViewModel()
) {
    val list by viewModel.motivationState.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        BackStackAppBar(
            navController = navController
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(all = SMALL_PADDING),
            verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
        ) {
            items(
                items = list,
                key = { motivation -> motivation.author }
            ) {
                it?.let { motivation ->
                    FeaturedItemContainer(
                        navController = navController,
                        image = motivation.image,
                        title = motivation.author,
                        description = motivation.message,
                        lightColor = Red1,
                        darkColor = Red2,
                        route = Screens.Motivation.route
                    )
                }
            }
        }
    }
}
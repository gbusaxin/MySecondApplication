package com.example.mysecondapplication.presentation.screens.training

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
import com.example.mysecondapplication.ui.theme.SMALL_PADDING
import com.example.mysecondapplication.ui.theme.Yellow1
import com.example.mysecondapplication.ui.theme.Yellow2

@ExperimentalCoilApi
@Composable
fun TrainingScreen(
    navController: NavHostController,
    viewModel: TrainingViewModel = hiltViewModel()
) {

    val list by viewModel.trainingState.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        BackStackAppBar(
            navController = navController
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(start = SMALL_PADDING, end = SMALL_PADDING),
            verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
        ) {
            items(
                items = list,
                key = { training -> training.id }
            ) {
                it?.let { training ->
                    FeaturedItemContainer(
                        navController = navController,
                        image = training.imageTrainer,
                        title = training.trainer,
                        description = training.aboutTrainer,
                        lightColor = Yellow1,
                        darkColor = Yellow2,
                        route = Screens.TrainingDetail.passDetail(it.id)
                    )
                }
            }
        }
    }
}

package com.example.mysecondapplication.presentation.screens.nutrition

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
import com.example.mysecondapplication.ui.theme.Blue1
import com.example.mysecondapplication.ui.theme.Blue2
import com.example.mysecondapplication.ui.theme.SMALL_PADDING

@ExperimentalCoilApi
@Composable
fun NutritionScreen(
    navController: NavHostController,
    viewModel: NutritionViewModel = hiltViewModel()
) {
    val list by viewModel.nutritionState.collectAsState()


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
                key = { nutrition -> nutrition.id }
            ) {
                it?.let { nutrition ->
                    FeaturedItemContainer(
                        navController = navController,
                        image = nutrition.backgroundImage,
                        title = nutrition.title,
                        description = nutrition.shortDesc,
                        lightColor = Blue1,
                        darkColor = Blue2,
                        route = Screens.NutritionDetail.passDetail(it.id)
                    )
                }
            }
        }
    }
}
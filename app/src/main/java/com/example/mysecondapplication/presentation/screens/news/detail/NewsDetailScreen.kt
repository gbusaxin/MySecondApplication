package com.example.mysecondapplication.presentation.screens.news.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.mysecondapplication.R
import com.example.mysecondapplication.presentation.components.BackStackAppBar
import com.example.mysecondapplication.ui.theme.MEDIUM_PADDING
import com.example.mysecondapplication.ui.theme.mainBackgroundColor
import com.example.mysecondapplication.ui.theme.textColor

@ExperimentalCoilApi
@Composable
fun NewsDetailScreen(
    navController: NavHostController,
    viewModel: NewsDetailViewModel = hiltViewModel()
) {

    val news by viewModel.selectedNewsState.collectAsState()

    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.mainBackgroundColor)
    ) {

        BackStackAppBar(navController = navController)
        news?.let {
            NewsContent(
                title = it.title,
                shortDesc = it.shortDescription,
                description = it.description,
                image = it.image
            )
        }
    }
}

@ExperimentalCoilApi
@Composable
fun NewsContent(
    title: String,
    shortDesc: String,
    description: String,
    image: String
) {

    val painter = rememberImagePainter(data = image) {
        placeholder(R.drawable.ic_placeholder)
        error(R.drawable.ic_error)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(MEDIUM_PADDING),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            painter = painter,
            contentDescription = "news"
        )
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = title,
            color = MaterialTheme.colors.textColor,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = shortDesc,
            color = MaterialTheme.colors.textColor,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = description,
            color = MaterialTheme.colors.textColor,
            style = MaterialTheme.typography.subtitle2,
            fontWeight = FontWeight.Bold
        )
    }

}

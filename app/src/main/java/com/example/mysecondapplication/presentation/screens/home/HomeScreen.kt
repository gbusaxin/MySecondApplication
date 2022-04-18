package com.example.mysecondapplication.presentation.screens.home

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mysecondapplication.R
import com.example.mysecondapplication.utils.FeaturedItems
import com.example.mysecondapplication.presentation.components.GreetingAppBar
import com.example.mysecondapplication.ui.theme.*
import com.example.mysecondapplication.utils.Constants.CELLS_COUNT
import com.example.mysecondapplication.utils.standardQuadTo

@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val features = listOf(
        FeaturedItems.Motivation,
        FeaturedItems.Nutrition,
        FeaturedItems.Training
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.mainBackgroundColor)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            GreetingAppBar()
            NewsContainer()
            FeatureSection(
                features = features,
                navController = navController
            )
        }
    }
}

@Composable
fun NewsContainer(
    title: String = stringResource(R.string.news_title),
    description: String = stringResource(R.string.news_description)
) {
    Row(
        modifier = Modifier
            .padding(all = MEDIUM_PADDING)
            .clip(RoundedCornerShape(SMALL_CORNER_SHAPE))
            .background(MaterialTheme.colors.cardColor)
            .padding(horizontal = MEDIUM_PADDING, vertical = LARGE_PADDING)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.textColor
            )
            Text(
                text = description,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.secondaryTextColor
            )
        }
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .padding(SMALL_PADDING),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier
                    .size(size = EXTRA_SMALL_ICON_SIZE),
                painter = painterResource(id = R.drawable.ic_newspaper),
                contentDescription = "news icon",
                tint = Color.White
            )
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun FeatureSection(
    features: List<FeaturedItems>,
    navController: NavHostController
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.padding(MEDIUM_PADDING),
            text = stringResource(R.string.featured),
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.textColor
        )
        LazyVerticalGrid(
            modifier = Modifier.fillMaxHeight(),
            cells = GridCells.Fixed(CELLS_COUNT),
            contentPadding = PaddingValues(
                start = EXTRA_SMALL_PADDING,
                end = EXTRA_SMALL_PADDING,
                bottom = HUGE_PADDING
            )
        ) {
            items(features.size) { currentItemIndex ->
                FeaturedItem(
                    feature = features[currentItemIndex],
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun FeaturedItem(
    feature: FeaturedItems,
    navController: NavHostController
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(EXTRA_SMALL_PADDING)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(SMALL_CORNER_SHAPE))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        val mediumFirstPont = Offset(0f, height * 0.3f)
        val mediumSecondPont = Offset(width * 0.1f, height * 0.35f)
        val mediumThirdPont = Offset(width * 0.4f, height * 0.05f)
        val mediumFourthPont = Offset(width * 0.75f, height * 0.7f)
        val mediumFifthPont = Offset(width * 1.4f, -height.toFloat())

        val darkColoredPath = Path().apply {
            moveTo(x = mediumFirstPont.x, y = mediumFirstPont.y)
            standardQuadTo(mediumFirstPont, mediumSecondPont)
            standardQuadTo(mediumSecondPont, mediumThirdPont)
            standardQuadTo(mediumThirdPont, mediumFourthPont)
            standardQuadTo(mediumFourthPont, mediumFifthPont)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        val lightColoredPath = Path().apply {
            moveTo(x = mediumFirstPont.x, y = mediumFirstPont.y)
            standardQuadTo(mediumFirstPont, mediumSecondPont)
            standardQuadTo(mediumSecondPont, mediumThirdPont)
            standardQuadTo(mediumThirdPont, mediumFourthPont)
            standardQuadTo(mediumFourthPont, mediumFifthPont)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            drawPath(path = darkColoredPath, color = feature.darkColor)
            drawPath(path = lightColoredPath, color = feature.lightColor)
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(MEDIUM_PADDING)
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                modifier = Modifier.align(Alignment.BottomStart),
                painter = painterResource(id = feature.icon),
                contentDescription = "feature icon",
                tint = Color.White
            )
            Text(
                modifier = Modifier
                    .clickable {
                        Log.d("CHECK_FEATURE_CLICK", "Clicked! Path is ${feature.route}")
                        navController.navigate(feature.route)
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(SMALL_CORNER_SHAPE))
                    .background(MaterialTheme.colors.buttonColor)
                    .padding(vertical = EXTRA_SMALL_PADDING, horizontal = MEDIUM_PADDING),
                text = stringResource(R.string.look),
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}






















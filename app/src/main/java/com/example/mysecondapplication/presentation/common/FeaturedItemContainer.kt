package com.example.mysecondapplication.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.mysecondapplication.R
import com.example.mysecondapplication.ui.theme.*

@ExperimentalCoilApi
@Composable
fun FeaturedItemContainer(
    navController: NavHostController,
    route: String,
    image: String,
    title: String,
    description: String,
    lightColor: Color = MaterialTheme.colors.cardColor,
    darkColor: Color = MaterialTheme.colors.cardColor
) {
    val painter = rememberImagePainter(data = image) {
        placeholder(R.drawable.ic_placeholder)
        error(R.drawable.ic_error)
    }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .height(FEATURED_IMAGE_SIZE)
            .background(if (isSystemInDarkTheme()) darkColor else lightColor)
            .padding(all = MEDIUM_PADDING)
            .clip(RoundedCornerShape(SMALL_CORNER_SHAPE))
            .clickable {
                navController.navigate(route = route)
            },
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            Image(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                alignment = Alignment.CenterStart,
                painter = painter,
                contentDescription = "featured image",
                contentScale = ContentScale.FillHeight,

                )

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .weight(2f)
                    .padding(all = MEDIUM_PADDING),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = title,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.textColor
                )
                Text(
                    text = description,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    style = MaterialTheme.typography.subtitle2,
                    color = MaterialTheme.colors.textColor.copy(0.5f)
                )
            }

        }
    }
}
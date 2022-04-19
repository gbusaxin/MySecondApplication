package com.example.mysecondapplication.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.mysecondapplication.R
import com.example.mysecondapplication.ui.theme.*

@Composable
fun BackStackAppBar(
    navController: NavHostController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = SMALL_PADDING)
            .background(MaterialTheme.colors.appBarColor),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            modifier = Modifier
                .size(MEDIUM_ICON_SIZE)
                .padding(start = SMALL_PADDING)
                .clickable {
                    navController.popBackStack()
                },
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = "ic back",
            tint = Color.White
        )

        Column(
            modifier = Modifier.padding(all = MEDIUM_PADDING),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.get_back),
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.textColor
            )
        }
    }
}
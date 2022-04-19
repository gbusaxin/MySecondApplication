package com.example.mysecondapplication.presentation.screens.splash

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.mysecondapplication.R
import com.example.mysecondapplication.navigation.Screens
import com.example.mysecondapplication.ui.theme.mainBackgroundColor
import com.example.mysecondapplication.utils.DataState

@ExperimentalCoilApi
@Composable
fun SplashScreen(
    navController: NavHostController,
    viewModel: SplashViewModel = hiltViewModel()
) {

    val onBoardingState by viewModel.onBoardingCompleted.collectAsState()

    val rotate = remember { Animatable(0f) }

    val response by viewModel.serverResponse.collectAsState()

    val context = LocalContext.current

    Log.d("RESP_RESP", response.toString())

    LaunchedEffect(key1 = true) {
        rotate.animateTo(
            targetValue = 360f,
            animationSpec = tween(
                durationMillis = 2000,
                delayMillis = 200
            )
        )
        when (response) {
            is DataState.Success<String?> -> {
                Log.d("DataState.SUCCESS", "Success! -> $response")
                responseError(
                    context = context,
                    navController = navController,
                    boardingState = onBoardingState
                )
//                responseSuccess(
//                    navController = navController,
//                    response = (response as DataState.Success<String?>).data?.trim()
//                )
            }
            is DataState.Error -> {
                Log.d("DataState.ERROR", "Error! -> $response")
                responseError(
                    context = context,
                    navController = navController,
                    boardingState = onBoardingState
                )
            }
            is DataState.Loading -> {
                Log.d("DataState.LOADING", "Loading... -> $response")
            }
            else -> {
                Log.d("DataState.ELSE", "Else... -> $response")
                responseError(
                    context = context,
                    navController = navController,
                    boardingState = onBoardingState
                )
            }
        }
    }
    Splash(rotate = rotate.value)
}

@ExperimentalCoilApi
@Composable
fun Splash(
    rotate: Float
) {
    val painter = rememberImagePainter(
        data = "http://95.217.132.144/celebrities/images/bet_match.png"
    ) {
        placeholder(R.drawable.ic_placeholder)
        error(R.drawable.ic_error)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.mainBackgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .rotate(rotate)
                .fillMaxSize(),
            painter = painter,
            contentDescription = stringResource(R.string.logo),
        )
    }
}

private fun responseSuccess(
    navController: NavHostController,
    response: String?
) {
    navController.popBackStack()
    Log.d("NAV_RESPONSE", response ?: "NULL")
    navController.navigate(
        Screens.Chrome.passResponse(route = response ?: "NULL")
    )
}

fun responseError(
    context: Context,
    navController: NavHostController,
    boardingState: Boolean
) {
    navController.popBackStack()
    if (boardingState) {
        navController.navigate(
            route = Screens.Home.route
        )
    } else {
        navController.navigate(
            route = Screens.Welcome.route
        )
    }
    Toast.makeText(context, context.getText(R.string.error_something_wrong), Toast.LENGTH_SHORT)
        .show()
}
package com.debanshu777.compose_github.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.debanshu777.compose_github.R

@Composable
fun Loader(id:Int,modifier:Modifier=Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(id))
    LottieAnimation(
        composition,
        modifier=modifier,
        alignment= Alignment.Center,
        contentScale=ContentScale.Fit,
        iterations = LottieConstants.IterateForever,
    )
}
package io.softpay.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import io.softpay.presentation.uibase.animations.infiniteFloatAnimation

@Composable
fun SplashScreenLogo() {
    Image(
        painterResource(R.drawable.softpaylogo),
        contentDescription = "",
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .width(240.dp)
            .offset(y = infiniteFloatAnimation().value.dp),
    )
}
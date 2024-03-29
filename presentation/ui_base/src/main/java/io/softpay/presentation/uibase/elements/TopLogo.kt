package io.softpay.presentation.uibase.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import io.softpay.presentation.uibase.R

@Composable
fun TopLogo() = Image(
    painterResource(R.drawable.softpaylogo),
    contentDescription = "",
    contentScale = ContentScale.Fit,
    modifier = Modifier
        .width(160.dp)
        .padding(18.dp)
)
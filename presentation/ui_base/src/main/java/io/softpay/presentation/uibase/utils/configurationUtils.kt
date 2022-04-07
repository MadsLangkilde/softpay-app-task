package io.softpay.presentation.uibase.utils

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun isInLandscape() = LocalConfiguration.current .orientation == Configuration.ORIENTATION_LANDSCAPE

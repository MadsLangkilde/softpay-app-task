package io.softpay.presentation.uibase.animations

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.IntOffset

@Composable
@ExperimentalAnimationApi
fun fadeInOut(
    visible: Boolean,
    content: @Composable AnimatedVisibilityScope.() -> Unit
) {
    return AnimatedVisibility(
        visible = visible,
        enter = fadeIn(),
        exit =fadeOut()
    ) { content() }
}
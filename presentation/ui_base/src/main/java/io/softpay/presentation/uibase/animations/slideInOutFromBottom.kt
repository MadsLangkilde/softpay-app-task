package io.softpay.presentation.uibase.animations

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.IntOffset

@Composable
@ExperimentalAnimationApi
fun slideInOutFromBottom(
    visible: Boolean,
    content: @Composable AnimatedVisibilityScope.() -> Unit
) {
    return AnimatedVisibility(
        visible = visible,
        enter = slideIn(
            initialOffset = { fullSize ->
                IntOffset(0, fullSize.height)
            },
            tween(400, easing = LinearOutSlowInEasing)
        ) + fadeIn(),
        exit = slideOut(
            targetOffset = { fullSize ->
                IntOffset(0, fullSize.height)
            },
            tween(400, easing = FastOutSlowInEasing)
        ) + fadeOut()
    ) { content() }
}
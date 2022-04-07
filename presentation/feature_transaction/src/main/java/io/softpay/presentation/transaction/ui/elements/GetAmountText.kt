package io.softpay.presentation.transaction.ui.elements

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import io.softpay.presentation.transaction.viewmodel.TransactionViewModel
import io.softpay.presentation.uibase.animations.fadeInOut
import io.softpay.presentation.uibase.theme.styles.DefaultTypography

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun GetAmountText(visible: Boolean, value: String) =
    fadeInOut(visible = visible) {
        Text(style = DefaultTypography.h3, text = value)
    }

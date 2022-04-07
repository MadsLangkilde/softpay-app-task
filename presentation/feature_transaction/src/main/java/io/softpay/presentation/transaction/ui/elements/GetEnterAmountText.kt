package io.softpay.presentation.transaction.ui.elements

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import io.softpay.presentation.transaction.R
import io.softpay.presentation.transaction.viewmodel.TransactionViewModel
import io.softpay.presentation.uibase.animations.fadeInOut
import io.softpay.presentation.uibase.theme.styles.DefaultTypography
import io.softpay.presentation.uibase.theme.styles.Grey

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun GetEnterAmountText(visible: Boolean, stringRes: Int) =
    fadeInOut(visible = visible) {
        Text(
            color = Grey,
            style = DefaultTypography.h6,
            text = stringResource(id = stringRes)
        )
    }

package io.softpay.presentation.transaction.ui.elements

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.softpay.presentation.transaction.viewmodel.TransactionViewModel
import io.softpay.presentation.uibase.animations.fadeInOut

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun GetProgressSpinner(viewModel: TransactionViewModel) =
    fadeInOut(visible = viewModel.isProcessing) {
        CircularProgressIndicator(modifier = Modifier.size(70.dp))
    }

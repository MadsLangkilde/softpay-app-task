package io.softpay.presentation.transaction.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.softpay.presentation.transaction.R
import io.softpay.presentation.transaction.ui.elements.GetAmountText
import io.softpay.presentation.transaction.ui.elements.GetEnterAmountText
import io.softpay.presentation.transaction.viewmodel.TransactionViewModel
import io.softpay.presentation.uibase.animations.fadeInOut
import io.softpay.presentation.uibase.theme.styles.DefaultTypography

@ExperimentalAnimationApi
@Composable
fun TransactionConfirmScreen(viewModel: TransactionViewModel) {
    fadeInOut(visible = viewModel.isAwaitingConfirmation) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    style = DefaultTypography.h5,
                    text = stringResource(id = R.string.confirm_transaction_headline)
                )
                Spacer(Modifier.height(10.dp))

                Text(text = viewModel.storeDetails?.name ?: "")
                Text(text = viewModel.storeDetails?.address ?: "")
                Text(text = viewModel.storeDetails?.postalCode ?: "")

                Spacer(Modifier.height(40.dp))

                GetEnterAmountText(
                    visible = !viewModel.isProcessing && viewModel.isAwaitingConfirmation,
                    stringRes = R.string.total_amount
                )
                GetAmountText(
                    visible = !viewModel.isProcessing && viewModel.isAwaitingConfirmation,
                    value = viewModel.amountValue
                )
            }
        }
    }
}

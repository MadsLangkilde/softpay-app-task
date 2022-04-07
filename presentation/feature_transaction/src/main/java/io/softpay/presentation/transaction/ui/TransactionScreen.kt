package io.softpay.presentation.transaction.ui

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.softpay.presentation.transaction.R
import io.softpay.presentation.transaction.ui.elements.GetAmountText
import io.softpay.presentation.transaction.ui.elements.GetEnterAmountText
import io.softpay.presentation.transaction.ui.elements.GetProgressSpinner
import io.softpay.presentation.transaction.viewmodel.TransactionViewModel
import io.softpay.presentation.uibase.animations.slideInOutFromBottom
import io.softpay.presentation.uibase.elements.NumberKeyboard
import io.softpay.presentation.uibase.elements.TopLogo
import io.softpay.presentation.uibase.theme.styles.*
import io.softpay.presentation.uibase.utils.isInLandscape
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TransactionScreen() {
    val viewModel = getViewModel<TransactionViewModel>()

    Scaffold {
        if (isInLandscape()) {
            Row {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TopLogo()
                    Spacer(Modifier.height(40.dp))
                    GetEnterAmountText(visible = !viewModel.isProcessing && !viewModel.isAwaitingConfirmation, R.string.enter_amount)
                    GetAmountText(visible = !viewModel.isProcessing && !viewModel.isAwaitingConfirmation, viewModel.amountValue)
                    TransactionConfirmScreen(viewModel = viewModel)
                }

                slideInOutFromBottom(visible = viewModel.showKeyBoard) {
                    GetNumberKeyboard(
                        modifier = Modifier
                            .background(
                                brush = blueVerticalGradient
                            )
                            .wrapContentWidth()
                            .fillMaxHeight()
                            .align(Alignment.CenterVertically)
                            .padding(8.dp),
                        viewModel = viewModel
                    )
                }
            }
        } else {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                GetProgressSpinner(viewModel = viewModel)

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        TopLogo()
                        Spacer(Modifier.height(80.dp))
                        GetEnterAmountText(visible = !viewModel.isProcessing && !viewModel.isAwaitingConfirmation, R.string.enter_amount)
                        GetAmountText(visible = !viewModel.isProcessing && !viewModel.isAwaitingConfirmation, viewModel.amountValue)
                        TransactionConfirmScreen(viewModel = viewModel)
                    }

                    slideInOutFromBottom(visible = viewModel.showKeyBoard) {
                        GetNumberKeyboard(
                            modifier = Modifier
                                .background(
                                    brush = blueVerticalGradient
                                )
                                .fillMaxWidth()
                                .padding(8.dp),
                            viewModel = viewModel
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun GetNumberKeyboard(modifier: Modifier, viewModel: TransactionViewModel) {
    NumberKeyboard(
        onClick = { digit -> viewModel.digitEntered(digit) },
        onSubmit = { viewModel.submit() },
        onDeleteChar = { viewModel.digitDeleted() },
        modifier = modifier
    )
}
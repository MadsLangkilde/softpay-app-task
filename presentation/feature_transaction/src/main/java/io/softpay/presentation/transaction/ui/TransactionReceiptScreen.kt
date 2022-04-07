package io.softpay.presentation.transaction.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import io.softpay.presentation.transaction.viewmodel.TransactionViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun TransactionReceiptScreen(navController: NavHostController) {
    val viewModel = getViewModel<TransactionViewModel>()

}
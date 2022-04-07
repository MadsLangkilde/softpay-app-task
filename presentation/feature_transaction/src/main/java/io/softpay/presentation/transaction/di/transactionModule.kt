package io.softpay.presentation.transaction.di

import io.softpay.presentation.transaction.viewmodel.TransactionViewModel
import io.softpay.sdk.TransactionManager
import io.softpay.sdk.impl.TransactionManagerImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val transactionModule = module {
    factory<TransactionManager> { TransactionManagerImpl() }
    viewModel { TransactionViewModel(get()) }
}
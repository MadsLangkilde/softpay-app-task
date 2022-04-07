package io.softpay.softpos.di

import io.softpay.presentation.transaction.di.transactionModule
import io.softpay.splashscreen.ui.splashScreenModule

val koinModuleList = listOf(
    // Feature modules
    splashScreenModule,
    transactionModule
)

package io.softpay.splashscreen.ui

import io.softpay.splashscreen.viewmodel.SplashScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashScreenModule = module {
    viewModel { SplashScreenViewModel() }
}
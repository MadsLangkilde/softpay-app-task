package io.softpay.presentation.uibase.navigation

sealed class AppNavItem(var screen_route: String) {
    object SplashScreen : AppNavItem("splash_screen")
    object TransactionScreen : AppNavItem("transaction_screen")
}
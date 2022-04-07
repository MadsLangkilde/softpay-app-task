package io.softpay.softpos.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import io.softpay.presentation.transaction.ui.TransactionScreen
import io.softpay.presentation.uibase.navigation.AppNavItem
import io.softpay.splashscreen.SplashScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = AppNavItem.SplashScreen.screen_route) {
        composable(AppNavItem.SplashScreen.screen_route) { SplashScreen(navController) }
        composable(AppNavItem.TransactionScreen.screen_route) { TransactionScreen() }
    }
}
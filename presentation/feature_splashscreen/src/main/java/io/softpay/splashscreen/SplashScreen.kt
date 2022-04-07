package io.softpay.splashscreen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import io.softpay.presentation.uibase.animations.fadeInOut
import io.softpay.presentation.uibase.navigation.AppNavItem
import io.softpay.splashscreen.viewmodel.SplashScreenViewModel
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.getViewModel

@ExperimentalAnimationApi
@Composable
fun SplashScreen(navController: NavHostController) {
    val viewModel = getViewModel<SplashScreenViewModel>()

    Scaffold {

        fadeInOut(visible = !viewModel.appReady) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SplashScreenLogo()
            }
        }
        LaunchedEffect(key1 = Unit) {
            viewModel.events.collectLatest { value ->
                when(value) {
                    is SplashScreenViewModel.Event.StartApp -> {
                        navController.navigate(AppNavItem.TransactionScreen.screen_route)
                    }
                }
            }
        }
    }

}

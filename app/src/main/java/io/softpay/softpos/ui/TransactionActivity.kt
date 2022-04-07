package io.softpay.softpos.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.navigation.compose.rememberNavController
import io.softpay.presentation.uibase.theme.SoftPayTheme
import io.softpay.softpos.navigation.NavigationGraph

class TransactionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SoftPayTheme {
                val navController = rememberNavController()
                Scaffold {
                    NavigationGraph(navController = navController)
                }
            }
        }
    }
}
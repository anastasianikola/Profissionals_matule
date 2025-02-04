package com.example.profissionals_matule

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.profissionals_matule.presentation.sing_in.SignIn
import com.example.profissionals_matule.presentation.home.Home

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "sign_in") {
        composable("sign_in") {
            SignIn(navController = navController)
        }
        composable("home") {
            Home()
        }
        composable("onboarding"){
        }
    }
}
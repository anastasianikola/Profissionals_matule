package com.example.profissionals_matule

import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.profissionals_matule.presentation.catalog.Catalog
import com.example.profissionals_matule.presentation.favourite.Favourite
import com.example.profissionals_matule.presentation.home.Home
import com.example.profissionals_matule.presentation.on_boarding.AppPreferences
import com.example.profissionals_matule.presentation.on_boarding.OnBoardingScreen
import com.example.profissionals_matule.presentation.popular.Popular
import com.example.profissionals_matule.presentation.sing_in.SignIn

@Composable
fun AppNavigation(appPreferences: AppPreferences) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = getStartDestination(appPreferences)) {
        composable("onboarding") {
            OnBoardingScreen {
                appPreferences.isOnboardingShown = true
                navController.navigate("signin") {
                    popUpTo("onboarding") { inclusive = true }
                }
            }
        }
        composable("signin") {
            SignIn {
                appPreferences.isUserLogin = true
                navController.navigate("home") {
                    popUpTo("signin") { inclusive = true }
                }
            }
        }
        composable("home") {
            Home(
                onPopularClick = {
                    navController.navigate("popular")
                },
                onCatalogClick = {
                    navController.navigate("catalog")
                }
            )
        }
        composable("popular"){
            Popular(
                onHomeClick = {
                    navController.navigate("home")
                },
                onFavouriteClick = {
                    navController.navigate("popular")
                }
            )
        }
        composable("favoutite"){
            Favourite()
        }
        composable("catalog"){
            Catalog(
                onHomeClick = {
                    navController.navigate("home")
                }
            )
        }
    }
}

private fun getStartDestination(appPreferences: AppPreferences): String {
    return when {
        !appPreferences.isOnboardingShown -> "onboarding"
        appPreferences.isUserLogin -> "home"
        else -> "signin"
    }
}
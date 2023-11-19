package com.littlelemon.foodorderingappcapstone

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(navController: NavController.Companion, preferenceRepo: PreferenceRepo) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = if(preferenceRepo.isUserLoggedIn()) {
            Home.route
        } else {
            Onboarding.route
        }
    ) {
        composable(Onboarding.route) {
            Onboarding(navController, preferenceRepo)
        }
        composable(Home.route) {
            Home(navController = navController)
        }
        composable(Profile.route) {
            Profile(navController = navController)
        }
    }
}
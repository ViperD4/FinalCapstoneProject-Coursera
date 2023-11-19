package com.littlelemon.foodorderingappcapstone

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(navController: NavController.Companion) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = if(isUserInfo()) {
            Home.route
        } else {
            Onboarding.route
        }
    ) {
        composable(Onboarding.route) {
            Onboarding(navController)
        }
        composable(Home.route) {
            Home(navController = navController)
        }
        composable(Profile.route) {
            Profile(navController = navController)
        }
    }
}

@Composable
fun isUserInfo(): Boolean {
    val context = LocalContext.current
    val userInfo = context.getSharedPreferences(userInfoKeyFile, Context.MODE_PRIVATE)
    val email = userInfo.getString(userEmail, "") ?: ""
    return email.isNotBlank()
}


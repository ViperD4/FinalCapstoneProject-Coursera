package com.littlelemon.foodorderingappcapstone

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavHostController, database: AppDatabase) {
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
            Home(navController = navController, database)
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


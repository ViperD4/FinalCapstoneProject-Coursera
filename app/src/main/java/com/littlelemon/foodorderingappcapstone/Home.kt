package com.littlelemon.foodorderingappcapstone

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun Home(navController: NavHostController) {
    Button(onClick = { navController.navigate(Profile.route) }) {
        Text(text = "Profile")
    }
}
package com.littlelemon.foodorderingappcapstone

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.littlelemon.foodorderingappcapstone.ui.theme.AppTheme
import com.littlelemon.foodorderingappcapstone.ui.theme.FoodOrderingAppCapstoneTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun Profile(navController: NavHostController) {
    val context = LocalContext.current
    val userInfo = context.getSharedPreferences(userInfoKeyFile, Context.MODE_PRIVATE)
    val firstName = userInfo.getString(userFirstName, "")
    val lastName = userInfo.getString(userLastName, "")
    val email = userInfo.getString(userEmail, "")

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .height(80.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(vertical = 20.dp, horizontal = 32.dp),
            painter = painterResource(
                id = R.drawable.logo),
            contentDescription = "Logo Image"
        )
        Box(
            modifier = Modifier
                .background(AppTheme.color.primaryGreen)
                .fillMaxWidth()
                .height(100.dp)
        ){
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                text = "",
                textAlign = TextAlign.Center,
                style = AppTheme.typography.highlight2,
                color = AppTheme.color.highlightWhite
            )
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, top = 50.dp, bottom = 50.dp),
            text = "Personal Information",
            style = AppTheme.typography.sectionTitle,
        )

        Text(
            modifier = Modifier
                .padding(start = 12.dp),
            text = "First Name:"
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, bottom = 30.dp, end = 12.dp),
            text = "$firstName"
        )

        Text(
            modifier = Modifier
                .padding(start = 12.dp),
            text = "Last Name:"
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, bottom = 30.dp, end = 12.dp),
            text = "$lastName"
        )

        Text(
            modifier = Modifier
                .padding(start = 12.dp),
            text = "Email Address:"
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, bottom = 30.dp, end = 12.dp),
            text = "$email"
        )
        Button(
            modifier = Modifier
                .padding(start = 12.dp, top = 50.dp, end = 12.dp)
                .fillMaxWidth(),
            onClick = {
                userInfo.edit().clear().apply()

                navController.navigate(Onboarding.route) {
                    popUpTo(Onboarding.route) { inclusive = true }
                }
            },
            colors = ButtonDefaults.buttonColors(
                Color(0xFFF4CE14)
            )
        ) {
            Text(
                text = "Log Out",
                color = AppTheme.color.black,
                style = AppTheme.typography.leadText
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
        Profile(
            navController = rememberNavController(),
            )
    }
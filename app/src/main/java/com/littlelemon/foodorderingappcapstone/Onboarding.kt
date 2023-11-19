package com.littlelemon.foodorderingappcapstone

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.littlelemon.foodorderingappcapstone.ui.theme.AppTheme
import com.littlelemon.foodorderingappcapstone.ui.theme.FoodOrderingAppCapstoneTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Onboarding(navController: NavHostController) {

    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
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
                text = "Let's get to know you",
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
            text = "First Name"
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, bottom = 30.dp, end = 12.dp),
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text(text = "") },
            )

        Text(
            modifier = Modifier
                .padding(start = 12.dp),
            text = "Last Name"
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, bottom = 30.dp, end = 12.dp),
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text(text = "") },
            )

        Text(
            modifier = Modifier
                .padding(start = 12.dp),
            text = "Email Address"
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, bottom = 30.dp, end = 12.dp),
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "") },
            )
        Button(
            modifier = Modifier
                .padding(start = 12.dp, top = 100.dp, end = 12.dp)
                .fillMaxWidth(),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                Color(0xFFF4CE14)
            )
        ) {
            Text(
                text = "Register",
                color = AppTheme.color.black,
                style = AppTheme.typography.leadText
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    FoodOrderingAppCapstoneTheme {
        Onboarding(navController)
    }
}
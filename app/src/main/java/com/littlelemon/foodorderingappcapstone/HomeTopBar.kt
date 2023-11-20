package com.littlelemon.foodorderingappcapstone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun HomeTopBar(navController: NavController) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .padding(vertical = 20.dp, horizontal = 32.dp),
                painter = painterResource(
                    id = R.drawable.logo
                ),
                contentDescription = "Logo Image"
            )
            IconButton(
                onClick = { navController.navigate(Profile.route) },
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 12.dp)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth(),
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile"
                )
            }
        }
    }
}
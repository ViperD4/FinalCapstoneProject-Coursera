package com.littlelemon.foodorderingappcapstone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@Composable
fun Home(navController: NavController, database: AppDatabase) {
    //val databaseMenuItems by database.menuItemDao().getAll().observeAsState(initial = emptyList())

    Button(onClick = { navController.navigate(Profile.route) }) {
        Text(text = "Profile")
    }
}

@Composable
fun HeroSection() {
    Column {
        Box(modifier = Modifier
            .fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .padding(vertical = 20.dp, horizontal = 32.dp),
                painter = painterResource(
                    id = R.drawable.logo),
                contentDescription = "Logo Image"
            )
            IconButton(
                onClick = { /*TODO*/ },
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

        Column(
            modifier = Modifier
                .background(Color(0xFF495E57))
                .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 16.dp)
        ) {
            Text(
                text = "Little Lemon",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFF4CE14)
            )
            Text(
                text = "Chicago",
                fontSize = 24.sp,
                color = Color(0xFFEDEFEE)
            )
            Row(
                modifier = Modifier
                    .padding(top = 18.dp)
            ) {
                Text(
                    text = "We are a family owned Mediterranean restaurant, focused on traditional recipes served with a modern twist.",
                    color = Color(0xFFEDEFEE),
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(bottom = 28.dp)
                        .fillMaxWidth(0.6f)
                )
                Image(
                    painter = painterResource(id = R.drawable.hero_image),
                    contentDescription = "Upper Panel Image",
                    modifier = Modifier.clip(RoundedCornerShape(20.dp))
                )
            }
        }
    }
}

@Composable
fun MenuItems() {

}

@Preview(showBackground = true)
@Composable
fun HerSectionPreview() {
    HeroSection()
}
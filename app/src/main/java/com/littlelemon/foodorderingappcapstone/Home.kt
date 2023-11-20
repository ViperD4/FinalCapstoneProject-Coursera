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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.littlelemon.foodorderingappcapstone.ui.theme.AppTheme

@Composable
fun Home(navController: NavController, database: AppDatabase) {
    val databaseMenuItems by database.menuItemDao().getAll().observeAsState(initial = emptyList())

    Column {
        HomeTopBar(navController)
        HeroSection(databaseMenuItems)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroSection(menuItemsLocal: List<MenuItemRoom>) {
    var menuItems = menuItemsLocal
    var selectedCategory by remember { mutableStateOf("") }

    Column {

        Column(
            modifier = Modifier
                .background(Color(0xFF495E57))
                .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 16.dp)
                .height(250.dp)
        ) {
            Text(
                text = "Little Lemon",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = AppTheme.color.primaryYellow
            )
            Text(
                text = "Chicago",
                fontSize = 24.sp,
                color = AppTheme.color.highlightWhite
            )
            Row(
                modifier = Modifier
                    .padding(top = 18.dp)
            ) {
                Text(
                    text = "We are a family owned Mediterranean restaurant, focused on traditional recipes served with a modern twist.",
                    color = AppTheme.color.highlightWhite,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(bottom = 28.dp)
                        .fillMaxWidth(0.6f)
                )
                Image(
                    painter = painterResource(id = R.drawable.hero_image),
                    contentDescription = "Upper Panel Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                )
            }
        }

       Column {
           var searchFilter by remember {mutableStateOf("")}
           OutlinedTextField(
               label = { Text(text = "Enter search phrase") },
               value = searchFilter,
               onValueChange = { searchFilter = it },
               shape = RoundedCornerShape(12.dp),
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(start = 12.dp, end = 12.dp),
               leadingIcon = {
                   Icon(
                       Icons.Default.Search, contentDescription = "Search"
                   )
               }
           )
           if (searchFilter.isNotEmpty()) {
               menuItems = menuItems.filter { it.title.contains(searchFilter, ignoreCase = true) }
           }
       }

        Column(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "ORDER FOR DELIVERY!",
                modifier = Modifier.padding(top = 10.dp),
                style = AppTheme.typography.sectionTitle
            )
            val scrollState = rememberScrollState()

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp)
                    .horizontalScroll(scrollState)
            ) {

                Button(
                    onClick = {selectedCategory = "starters"},
                    modifier = Modifier.height(40.dp),
                    contentPadding = PaddingValues(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = AppTheme.color.highlightWhite)
                ) {
                    Text(
                        text = "Starters",
                        style = AppTheme.typography.sectionCategory,
                        color = AppTheme.color.primaryGreen
                    )
                }

                Button(
                    onClick = {selectedCategory = "mains"},
                    modifier = Modifier.height(40.dp),
                    contentPadding = PaddingValues(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = AppTheme.color.highlightWhite)
                ) {
                    Text(
                        text = "Mains",
                        style = AppTheme.typography.sectionCategory,
                        color = AppTheme.color.primaryGreen
                    )
                }

                Button(
                    onClick = {selectedCategory = "desserts"},
                    modifier = Modifier.height(40.dp),
                    contentPadding = PaddingValues(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = AppTheme.color.highlightWhite)
                ) {
                    Text(
                        text = "Desserts",
                        style = AppTheme.typography.sectionCategory,
                        color = AppTheme.color.primaryGreen
                    )
                }

                Button(
                    onClick = {selectedCategory = "drinks"},
                    modifier = Modifier.height(40.dp),
                    contentPadding = PaddingValues(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = AppTheme.color.highlightWhite)
                ) {
                    Text(
                        text = "Drinks",
                        style = AppTheme.typography.sectionCategory,
                        color = AppTheme.color.primaryGreen
                    )
                }
            }
            if (selectedCategory.isNotEmpty()) {
                menuItems = menuItems.filter { it.category.contains(selectedCategory) }
            }
            MenuItems(menuItems)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MenuItems(items: List<MenuItemRoom>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
    ) {
        items(
            items = items,
            itemContent = { menuItem ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column {
                        Text(
                            text = menuItem.title,
                            style = AppTheme.typography.cardTitle)
                        Text(
                            text = menuItem.desc,
                            style = AppTheme.typography.paragraph,
                            modifier = Modifier
                                .fillMaxWidth(0.75f)
                                .padding(top = 5.dp)
                                .padding(bottom = 5.dp)
                        )
                        Text(
                            text = "$%.2f".format(menuItem.price),
                            style = AppTheme.typography.highlight
                        )
                    }

                    GlideImage(
                        model = menuItem.image,
                        contentDescription = "Menu Item Image",
                        modifier = Modifier.clip(RoundedCornerShape(10.dp))
                    )
                }
            }
        )
    }
}


package com.example.groceryapp.presentation.shop

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.groceryapp.R
import com.example.groceryapp.presentation.bottomNavigationBar.BottomNavigation
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPagerIndicator

data class Item1(val imageResId: Int)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ShopScreen(navController: NavController) {

    var search by remember { mutableStateOf("") }
    val bannerState = rememberPagerState()

    val banner = listOf(
        Item1(imageResId = R.drawable.banner1),
        Item1(imageResId = R.drawable.banner2),
        Item1(imageResId = R.drawable.banner3),
        Item1(imageResId = R.drawable.banner4),
    )

    val exclusiveItem = listOf(
        ExclusiveItem(R.drawable.watermelon, "Water melon", "Good for health", "1.00$"),
        ExclusiveItem(R.drawable.banana, "Banana", "Good for health", "2.00$"),
        ExclusiveItem(R.drawable.apple, "Red Apple", "Good for health", "4.00$"),
        ExclusiveItem(R.drawable.apple, "Red Apple", "Good for health", "4.00$"),
        ExclusiveItem(R.drawable.apple, "Red Apple", "Good for health", "4.00$"),
        ExclusiveItem(R.drawable.apple, "Red Apple", "Good for health", "4.00$"),
    )

    val bestSellingItem = listOf(
        ExclusiveItem(R.drawable.apple, "Water melon", "Good for health", "1.00$"),
        ExclusiveItem(R.drawable.apple, "Banana", "Good for health", "2.00$"),
        ExclusiveItem(R.drawable.apple, "Red Apple", "Good for health", "4.00$"),
        ExclusiveItem(R.drawable.apple, "Red Apple", "Good for health", "4.00$"),
        ExclusiveItem(R.drawable.apple, "Red Apple", "Good for health", "4.00$"),
        ExclusiveItem(R.drawable.apple, "Red Apple", "Good for health", "4.00$"),
    )

    val groceriesItem = listOf(
        ExclusiveItem(R.drawable.banana, "Water melon", "Good for health", "1.00$"),
        ExclusiveItem(R.drawable.banana, "Banana", "Good for health", "2.00$"),
        ExclusiveItem(R.drawable.banana, "Red Apple", "Good for health", "4.00$"),
        ExclusiveItem(R.drawable.banana, "Red Apple", "Good for health", "4.00$"),
        ExclusiveItem(R.drawable.banana, "Red Apple", "Good for health", "4.00$"),
        ExclusiveItem(R.drawable.banana, "Red Apple", "Good for health", "4.00$"),
    )

    val itemsList = listOf(
        Pair(R.drawable.g1, "Pulse"),
        Pair(R.drawable.g2, "Rice"),
        Pair(R.drawable.g2, "Rice")
    )

    Scaffold(
        bottomBar = { BottomNavigation(navController) },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(36.dp))
            Image(
                painter = painterResource(id = R.drawable.orangecarrot),
                contentDescription = null,
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.locationpin),
                    contentDescription = null
                )
                Text(
                    text = "Phnom Penh, Cambodia",
                    style = MaterialTheme.typography.titleMedium,
                    color = colorResource(id = R.color.black)

                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = search,
                onValueChange = { search = it },
                placeholder = {
                    Text(
                        "Search store...",
                        style = TextStyle(fontSize = 16.sp, color = Color.Gray)
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    focusedIndicatorColor = colorResource(id = R.color.white2),
                    unfocusedIndicatorColor = colorResource(id = R.color.white2),
                    disabledIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(15.dp),
                textStyle = TextStyle(fontSize = 16.sp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                },
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .shadow(elevation = 16.dp, shape = RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                HorizontalPager(
                    state = bannerState,
                    count = banner.size,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .height(200.dp)
                ) { page ->
                    val item = banner[page]
                    Image(
                        contentScale = ContentScale.None,
                        painter = painterResource(id = item.imageResId),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()

                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                HorizontalPagerIndicator(
                    pagerState = bannerState,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 16.dp),
                    activeColor = colorResource(R.color.green1),
                    inactiveColor = Color.Gray
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 8.dp)
            ) {
                Text(
                    text = "Exclusive Offer",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.black)
                )
                Text(
                    text = "See all",
                    style = MaterialTheme.typography.bodyLarge,
                    color = colorResource(id = R.color.green1),
                )
            }
            Box (modifier = Modifier.padding(horizontal = 8.dp)){
                ExclusiveHorizontalItemList(items = exclusiveItem, modifier = Modifier)
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Best Selling",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.black)
                )
                Text(
                    text = "See all",
                    style = MaterialTheme.typography.bodyLarge,
                    color = colorResource(id = R.color.green1)
                )
            }
            Box (modifier = Modifier.padding(horizontal = 8.dp)) {
                ExclusiveHorizontalItemList(items = bestSellingItem)
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Groceries",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.black)
                )
                Text(
                    text = "See all",
                    style = MaterialTheme.typography.bodyLarge,
                    color = colorResource(id = R.color.green1)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            LazyRow(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
            ) {
                items(itemsList) { item ->
                    Card(
                        modifier = Modifier
                            .width(180.dp)
                            .padding(horizontal = 8.dp),
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(0.5.dp,Color.Gray.copy(alpha = 0.6F)),
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Image(
                                painter = painterResource(id = item.first),
                                contentDescription = null,
                                modifier = Modifier.size(50.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = item.second,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Box(modifier = Modifier.padding(horizontal = 8.dp)) {
                ExclusiveHorizontalItemList(items = groceriesItem)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewShop() {
    ShopScreen(navController = rememberNavController())
}
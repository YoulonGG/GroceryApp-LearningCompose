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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.groceryapp.R
import com.example.groceryapp.core.components.DescriptionText
import com.example.groceryapp.core.components.HeaderText
import com.example.groceryapp.core.components.SearchField
import com.example.groceryapp.presentation.bottomNavigationBar.BottomNavigation
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPagerIndicator

data class Item1(val imageResId: Int)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ShopScreen(navController: NavController) {

    var shopSearch by remember { mutableStateOf("") }
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
        floatingActionButton = {
            FloatingActionButton(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onSurface,
                onClick = {  },
                modifier = Modifier
            ) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surface)
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(36.dp))
            Image(
                painter = painterResource(id = R.drawable.orangecarrot),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
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
                DescriptionText(
                    text = "Phnom Penh, Cambodia",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface

                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            SearchField(
                value = shopSearch,
                onValueChange ={ shopSearch = it }
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
            HeaderText(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "Exclusive Offer",
                endText = "See all"
            )
            Box (modifier = Modifier.padding(horizontal = 8.dp)){
                ExclusiveHorizontalItemList(items = exclusiveItem, modifier = Modifier)
            }
            HeaderText(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "Best Selling",
                endText = "See all"
            )
            Box (modifier = Modifier.padding(horizontal = 8.dp)) {
                ExclusiveHorizontalItemList(items = bestSellingItem)
            }
            HeaderText(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "Groceries",
                endText = "See all"
            )
            Spacer(modifier = Modifier.height(8.dp))
            LazyRow(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
            ) {
                items(itemsList) { item ->
                    Card(
                        modifier = Modifier
                            .background(color = MaterialTheme.colorScheme.surface)
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
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSurface
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
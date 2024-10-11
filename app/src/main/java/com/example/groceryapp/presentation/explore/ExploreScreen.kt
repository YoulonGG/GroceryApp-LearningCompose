package com.example.groceryapp.presentation.explore

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.TopAppBar
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.groceryapp.R
import com.example.groceryapp.presentation.app.RouteDestinations
import com.example.groceryapp.presentation.bottomNavigationBar.BottomNavigation

@Composable
fun ExploreScreen(navController: NavController) {

    var exploreSearch by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.background(color = MaterialTheme.colorScheme.secondary).padding(top = 42.dp),
        bottomBar = { BottomNavigation(navController) },
        topBar = {
            TopAppBar(
                contentColor = MaterialTheme.colorScheme.secondary,
                backgroundColor = MaterialTheme.colorScheme.secondary,
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Find Products",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.surface,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.secondary)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = exploreSearch,
                onValueChange = { exploreSearch = it },
                placeholder = { Text(
                    "Search store...",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Gray)
                ) },
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
            Spacer(modifier = Modifier.height(8.dp))
            Column(
                modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.secondary).padding(horizontal = 16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .clickable { navController.navigate(RouteDestinations.EXPLORE_FRUIT_VEGETABLE) }
                            .weight(1f)
                            .width(180.dp)
                            .height(200.dp)
                            .background(color = MaterialTheme.colorScheme.secondary)
                            .border(BorderStroke(0.5.dp, color = colorResource(id = R.color.blue1)), shape = RoundedCornerShape(10.dp)),
                        shape = RoundedCornerShape(10.dp),
                        elevation = 4.dp
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .padding(4.dp)
                                .fillMaxSize()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.explore1),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(115.dp)
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            androidx.compose.material.Text(
                                modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(horizontal = 8.dp),
                                text = "Fresh Fruits and Vegetables",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSecondary,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Card(
                        modifier = Modifier
                            .clickable { navController.navigate(RouteDestinations.EXPLORE_COOKING_INCREDIENT) }
                            .weight(1f)
                            .width(180.dp)
                            .height(200.dp)
                            .background(color = MaterialTheme.colorScheme.secondary)
                            .border(BorderStroke(1.dp, color = colorResource(id = R.color.purple_200)), shape = RoundedCornerShape(10.dp)),
                        shape = RoundedCornerShape(10.dp),
                        elevation = 4.dp
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .padding(4.dp)
                                .fillMaxSize()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.explore2),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(115.dp)
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(horizontal = 8.dp),
                                text = "Cooking Oil and Ghee",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSecondary,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .clickable { navController.navigate(RouteDestinations.EXPLORE_MEAT_FISH) }
                            .weight(1f)
                            .width(180.dp)
                            .height(200.dp)
                            .background(color = MaterialTheme.colorScheme.secondary)
                            .border(BorderStroke(1.dp, color = colorResource(id = R.color.teal_700)), shape = RoundedCornerShape(10.dp)),
                        shape = RoundedCornerShape(10.dp),
                        elevation = 4.dp
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .padding(4.dp)
                                .fillMaxSize()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.explore3),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(115.dp)
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            androidx.compose.material.Text(
                                modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(horizontal = 8.dp),
                                text = "Meat and Fish",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSecondary,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Card(
                        modifier = Modifier
                            .clickable { navController.navigate(RouteDestinations.EXPLORE_BAKERY_SNACK) }
                            .weight(1f)
                            .width(180.dp)
                            .height(200.dp)
                            .background(color = MaterialTheme.colorScheme.secondary)
                            .border(BorderStroke(1.dp, color = colorResource(id = R.color.green1)), shape = RoundedCornerShape(10.dp)),
                        shape = RoundedCornerShape(10.dp),
                        elevation = 4.dp
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .padding(4.dp)
                                .fillMaxSize()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.explore4),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(115.dp)
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            androidx.compose.material.Text(
                                modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(horizontal = 8.dp),
                                text = "Bakery and Snacks",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSecondary,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .clickable { navController.navigate(RouteDestinations.EXPLORE_DAIRY) }
                            .weight(1f)
                            .width(180.dp)
                            .height(200.dp)
                            .background(color = MaterialTheme.colorScheme.secondary)
                            .border(BorderStroke(1.dp, color = colorResource(id = R.color.blue2)), shape = RoundedCornerShape(10.dp)),
                        shape = RoundedCornerShape(10.dp),
                        elevation = 4.dp
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .padding(4.dp)
                                .fillMaxSize()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.explore5),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(115.dp)
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            androidx.compose.material.Text(
                                modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(horizontal = 8.dp),
                                text = "Dairy and Egg",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSecondary,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .clickable { navController.navigate(RouteDestinations.EXPLORE_BEVERAGES) }
                            .width(180.dp)
                            .height(200.dp)
                            .background(color = MaterialTheme.colorScheme.secondary)
                            .border(BorderStroke(1.dp, color = colorResource(id = R.color.purple_200)), shape = RoundedCornerShape(10.dp)),
                        shape = RoundedCornerShape(10.dp),
                        elevation = 4.dp
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .padding(4.dp)
                                .fillMaxSize()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.explore6),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(115.dp)
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            androidx.compose.material.Text(
                                modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(horizontal = 8.dp),
                                text = "Beverages",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSecondary,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewExplore() {
    ExploreScreen(navController = rememberNavController())
}
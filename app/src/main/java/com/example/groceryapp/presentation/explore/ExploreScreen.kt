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
        modifier = Modifier.background(color = Color.White).padding(top = 42.dp),
        bottomBar = { BottomNavigation(navController) },
        topBar = {
            TopAppBar(
                contentColor = Color.White,
                backgroundColor = Color.White,
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Find Products",
                        fontSize = 18.sp,
                        color = Color.Black,
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
                .background(color = Color.White)
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = exploreSearch,
                onValueChange = { exploreSearch = it },
                placeholder = { Text("Search store...", style = TextStyle(fontSize = 16.sp, color = Color.Gray)) },
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
                    .padding(horizontal = 10.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier.fillMaxSize().background(color = Color.White)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth().background(color = Color.White)
                ) {
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .width(180.dp)
                            .height(200.dp)
                            .background(color = Color.White)
                            .padding(horizontal = 10.dp, vertical = 10.dp)
                            .border(BorderStroke(1.dp, color = colorResource(id = R.color.blue1)), shape = RoundedCornerShape(10.dp)),
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
                                    .size(110.dp)
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            androidx.compose.material.Text(
                                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                                text = "Fresh Fruits and Vegetables",
                                fontSize = 14.sp,
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .width(180.dp)
                            .height(200.dp)
                            .background(color = Color.White)
                            .padding(horizontal = 10.dp, vertical = 10.dp)
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
                                    .size(110.dp)
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            androidx.compose.material.Text(
                                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                                text = "Cooking Oil and Ghee",
                                fontSize = 14.sp,
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .width(180.dp)
                            .height(200.dp)
                            .background(color = Color.White)
                            .padding(horizontal = 10.dp, vertical = 10.dp)
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
                                    .size(110.dp)
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            androidx.compose.material.Text(
                                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                                text = "Meat and Fish",
                                fontSize = 14.sp,
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .width(180.dp)
                            .height(200.dp)
                            .background(color = Color.White)
                            .padding(horizontal = 10.dp, vertical = 10.dp)
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
                                    .size(110.dp)
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            androidx.compose.material.Text(
                                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                                text = "Bakery and Snacks",
                                fontSize = 14.sp,
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .width(180.dp)
                            .height(200.dp)
                            .background(color = Color.White)
                            .padding(horizontal = 10.dp, vertical = 10.dp)
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
                                    .size(110.dp)
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            androidx.compose.material.Text(
                                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                                text = "Dairy and Egg",
                                fontSize = 14.sp,
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .clickable { navController.navigate(RouteDestinations.EXPLORE_BEVERAGES) }
                            .width(180.dp)
                            .height(200.dp)
                            .background(color = Color.White)
                            .padding(horizontal = 10.dp, vertical = 10.dp)
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
                                    .size(110.dp)
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            androidx.compose.material.Text(
                                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                                text = "Beverages",
                                fontSize = 14.sp,
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .clickable { navController.navigate(RouteDestinations.EXPLORE_BEVERAGES) }
                            .width(180.dp)
                            .height(200.dp)
                            .background(color = Color.White)
                            .padding(horizontal = 10.dp, vertical = 10.dp)
                            .border(BorderStroke(1.dp, color = colorResource(id = R.color.purple_700)), shape = RoundedCornerShape(10.dp)),
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
                                    .size(110.dp)
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            androidx.compose.material.Text(
                                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                                text = "Beverages",
                                fontSize = 14.sp,
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .clickable { navController.navigate(RouteDestinations.EXPLORE_BEVERAGES) }
                            .width(180.dp)
                            .height(200.dp)
                            .background(color = Color.White)
                            .padding(horizontal = 10.dp, vertical = 10.dp)
                            .border(BorderStroke(1.dp, color = colorResource(id = R.color.blue1)), shape = RoundedCornerShape(10.dp)),
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
                                    .size(110.dp)
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            androidx.compose.material.Text(
                                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                                text = "Beverages",
                                fontSize = 14.sp,
                                color = Color.Black,
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
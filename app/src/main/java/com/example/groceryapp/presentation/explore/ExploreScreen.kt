package com.example.groceryapp.presentation.Explore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Modifier
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
import com.example.groceryapp.presentation.BottomNavigationBar.BottomNavigation

@Composable
fun ExploreScreen(navController: NavController) {

    val exploreItem = listOf(
        ExploreItem(R.drawable.explore1, "Fresh Fruits and Vegetables"),
        ExploreItem(R.drawable.explore2, "Cooking Oil & Ghee"),
        ExploreItem(R.drawable.explore3, "Meat & Fish"),
        ExploreItem(R.drawable.explore4, "Bakery & Snacks"),
        ExploreItem(R.drawable.explore4, "Dairy & Egg"),
        ExploreItem(R.drawable.explore5, "Beverages"),
        ExploreItem(R.drawable.explore6, "Beverages"),
        ExploreItem(R.drawable.explore6, "Beverages"),
    )

    var exploreSearch by remember { mutableStateOf("") }

    Scaffold(
        bottomBar = { BottomNavigation(navController) },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = colorResource(id = R.color.white2))
                .padding(horizontal = 8.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Find Products",
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
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
            ExploreItemList(items = exploreItem)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewExplore() {
    ExploreScreen(navController = rememberNavController())
}
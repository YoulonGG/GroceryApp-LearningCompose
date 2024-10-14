package com.example.groceryapp.presentation.explore

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.groceryapp.R
import com.example.groceryapp.core.components.DescriptionText
import com.example.groceryapp.core.components.HeaderText
import com.example.groceryapp.core.components.SearchField
import com.example.groceryapp.presentation.app.RouteDestinations
import com.example.groceryapp.presentation.bottomNavigationBar.BottomNavigation

@Composable
fun ExploreScreen(navController: NavController) {

    var exploreSearch by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.background(MaterialTheme.colorScheme.surface),
        bottomBar = { BottomNavigation(navController) },
        topBar = {
            TopAppBar(
                contentColor = MaterialTheme.colorScheme.onSurface,
                backgroundColor = MaterialTheme.colorScheme.surface,
                title = {
                    HeaderText(
                        text = "Find Products",
                        textAlign = TextAlign.Center,
                    )
                },
                modifier = Modifier.statusBarsPadding()
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surface)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            SearchField(
                value = exploreSearch,
                onValueChange ={ exploreSearch = it }
            )
            Spacer(modifier = Modifier.height(8.dp))
            val categories = listOf(
                Pair("Fresh Fruits and Vegetables", R.drawable.explore1 to RouteDestinations.EXPLORE_FRUIT),
                Pair("Cooking Oil and Ghee", R.drawable.explore2 to RouteDestinations.EXPLORE_COOKING),
                Pair("Meat and Fish", R.drawable.explore3 to RouteDestinations.EXPLORE_MEAT),
                Pair("Bakery and Snacks", R.drawable.explore4 to RouteDestinations.EXPLORE_BAKERY),
                Pair("Dairy and Egg", R.drawable.explore5 to RouteDestinations.EXPLORE_DAIRY),
                Pair("Beverages", R.drawable.explore6 to RouteDestinations.EXPLORE_BEVERAGES)
            )

            CategoryGrid(categories, navController)
        }
    }
}

@Composable
fun CategoryGrid(categories: List<Pair<String, Pair<Int, String>>>, navController: NavController) {
    categories.chunked(2).forEach { rowItems ->
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            rowItems.forEach { (text, iconAndDestination) ->
                CategoryCard(text = text, iconRes = iconAndDestination.first) {
                    navController.navigate(iconAndDestination.second)
                }
            }
        }
    }
}

@Composable
fun CategoryCard(text: String, iconRes: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .clickable(onClick = onClick)
            .width(180.dp)
            .height(200.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6F))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier.size(115.dp).clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(8.dp))
            DescriptionText(
                text = text,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}





@Preview(showBackground = true)
@Composable
fun PreviewExplore() {
    ExploreScreen(navController = rememberNavController())
}
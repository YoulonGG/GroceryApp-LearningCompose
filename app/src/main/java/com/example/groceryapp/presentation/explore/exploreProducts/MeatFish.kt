package com.example.groceryapp.presentation.explore.exploreProducts

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.groceryapp.R
import com.example.groceryapp.presentation.explore.BeverageList
import com.example.groceryapp.presentation.explore.ExploreItemsClass

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeatScreen(navController: NavController) {

    val meat = listOf(
        ExploreItemsClass(R.drawable.android, "Diet Coke", "355ML, Price", "1.99$"),
        ExploreItemsClass(R.drawable.android, "Sprite", "325ML, Price", "1.50$"),
    )

    var showFilterDialog by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.background(color = Color.White),
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 16.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp).clickable { navController.popBackStack() }
                        )
                        Text(
                            text = "Meat and Fish",
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.filter),
                            contentDescription = "Settings",
                            modifier = Modifier.size(24.dp).clickable {  showFilterDialog = true }
                        )
                        if (showFilterDialog) {
                            Filter(onDismiss = { showFilterDialog = false })
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = Color.White)
        ) {
            Box(modifier = Modifier.padding(horizontal = 8.dp)) {
                BeverageList(items = meat)
            }
        }
    }
}
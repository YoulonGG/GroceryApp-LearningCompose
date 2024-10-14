package com.example.groceryapp.presentation.explore.exploreItems

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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.groceryapp.R
import com.example.groceryapp.core.components.HeaderText
import com.example.groceryapp.presentation.explore.ExploreClass
import com.example.groceryapp.presentation.explore.ExploreList


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FruitAndVegetableScreen(navController: NavController) {

        val beverages = listOf(
            ExploreClass(R.drawable.comingsoon, "Diet Coke", "355ML, Price", "1.99$"),
            ExploreClass(R.drawable.comingsoon, "Sprite", "325ML, Price", "1.50$"),
            ExploreClass(R.drawable.comingsoon, "Apple & Grape Juice", "2L, Price", "15.99$"),
            ExploreClass(R.drawable.comingsoon, "Orange Juice", "2L, Price", "15.99$"),
            ExploreClass(R.drawable.comingsoon, "Coca Cola", "325ML, Price", "4.99$"),
            ExploreClass(R.drawable.comingsoon, "Pepsi", "335ML, Price", "4.99$"),
        )

        var showFilterDialog by remember { mutableStateOf(false) }

        Scaffold(
            modifier = Modifier.background(color = MaterialTheme.colorScheme.surface),
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
                                modifier = Modifier.size(20.dp).clickable { navController.popBackStack() }
                            )
                            HeaderText(
                                text = "Fruits And Vegetables",
                                textAlign = TextAlign.Center,
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.filter),
                                contentDescription = "Settings",
                                modifier = Modifier.size(20.dp).clickable {  showFilterDialog = true }
                            )
                            if (showFilterDialog) {
                                Filter(onDismiss = { showFilterDialog = false })
                            }
                        }
                    },
                    modifier = Modifier.statusBarsPadding()
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
                    ExploreList(items = beverages)
                }
            }
        }
    }
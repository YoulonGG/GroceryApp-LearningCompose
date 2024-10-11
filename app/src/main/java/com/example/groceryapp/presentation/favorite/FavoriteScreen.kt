package com.example.groceryapp.presentation.favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.groceryapp.R
import com.example.groceryapp.presentation.bottomNavigationBar.BottomNavigation

@Composable
fun FavoriteScreen(navController: NavController) {

    val sampleItems = listOf(
        FavoriteClass(R.drawable.b1, "Apple", "Fresh Red Apple", "$1.50"),
        FavoriteClass(R.drawable.b2, "Banana", "Organic Banana", "$0.99"),
        FavoriteClass(R.drawable.b3, "Orange", "Juicy Orange", "$1.20")
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.secondary),
        bottomBar = { BottomNavigation(navController) },
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .background(color = MaterialTheme.colorScheme.secondary)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondary)
                    .statusBarsPadding(),
                backgroundColor = MaterialTheme.colorScheme.secondary,
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Favorite",
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
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.secondary)
        ) {
            Box(modifier = Modifier.padding(horizontal = 4.dp)) {
                CartList(favoriteItems = sampleItems)
            }
        }
    }
}


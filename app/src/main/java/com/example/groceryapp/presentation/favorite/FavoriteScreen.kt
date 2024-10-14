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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.groceryapp.R
import com.example.groceryapp.core.components.HeaderText
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
            .background(color = Color.White),
        bottomBar = { BottomNavigation(navController) },
        topBar = {
            TopAppBar(
                contentColor = MaterialTheme.colorScheme.onSurface,
                backgroundColor = MaterialTheme.colorScheme.surface,
                title = {
                    HeaderText(
                        text = "Favorite",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
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
            Box(modifier = Modifier.padding(horizontal = 4.dp)) {
                CartList(favoriteItems = sampleItems)
            }
        }
    }
}


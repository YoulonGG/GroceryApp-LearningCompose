package com.example.groceryapp.presentation.Cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.groceryapp.presentation.BottomNavigationBar.BottomNavigation

@Composable
fun CartScreen(navController: NavController) {

    Scaffold(
        bottomBar = { BottomNavigation(navController) },
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Text(text = "Account")
        }
    }
}
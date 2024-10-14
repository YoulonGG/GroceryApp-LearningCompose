package com.example.groceryapp.presentation.app

import android.os.Build
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.groceryapp.ui.theme.GroceryAppTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GroceryAppTheme(dynamicColor = false) {
                App()
            }
        }
    }
}





@Composable
fun App() {
    val navController = rememberNavController()
    Route(navController) 
}

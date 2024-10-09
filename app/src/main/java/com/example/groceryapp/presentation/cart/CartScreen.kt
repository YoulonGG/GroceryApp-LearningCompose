package com.example.groceryapp.presentation.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.groceryapp.R
import com.example.groceryapp.presentation.bottomNavigationBar.BottomNavigation

@Composable
fun CartScreen(navController: NavController) {
    val cart = listOf(
        CartClass(R.drawable.cart1, "Egg Chicken Red", "4pcs, Price", 1.50),
        CartClass(R.drawable.cart2, "Bell Peper Red", "1kg, Price", 4.50),
        CartClass(R.drawable.cart3, "Organic Banana", "12kg, Price", 3.00),
        CartClass(R.drawable.cart4, "Ginger", "250gm, Price", 2.50),
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        bottomBar = { BottomNavigation(navController) },
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .statusBarsPadding(),
                backgroundColor = Color.White,
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Cart",
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
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = Color.White)
        ) {
            Box(modifier = Modifier.padding(horizontal = 4.dp)) {
                CartList(cart,navController)
            }
        }
    }
}

    @Preview(showBackground = true)
@Composable
fun PreviewCart() {
    CartScreen(navController = rememberNavController())
}


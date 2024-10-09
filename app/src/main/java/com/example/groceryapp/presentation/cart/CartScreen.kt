package com.example.groceryapp.presentation.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        CartClass(R.drawable.cart1, "Egg Chicken Red", "4pcs, Price", 1.99),
        CartClass(R.drawable.cart2, "Bell Peper Red", "1kg, Price", 4.99),
        CartClass(R.drawable.cart3, "Organic Banana", "12kg, Price", 3.00),
        CartClass(R.drawable.cart4, "Ginger", "250gm, Price", 2.99)
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        bottomBar = { BottomNavigation(navController) },
        topBar = {
            TopAppBar(
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
            CartList(cart)
        }

        Spacer(modifier = Modifier.height(60.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCart() {
    CartScreen(navController = rememberNavController())
}

//Button(
//colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.green1)),
//onClick = {},
//shape = RoundedCornerShape(15.dp),
//modifier = Modifier
//.padding(horizontal = 36.dp)
//.height(48.dp)
//.fillMaxWidth()
//) {
//    Text(
//        fontSize = 16.sp,
//        color = Color.White,
//        text = "Get Start",
//        fontWeight = FontWeight.Bold,
//    )
//}
package com.example.groceryapp.presentation.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.groceryapp.R
import com.example.groceryapp.core.components.DescriptionText
import com.example.groceryapp.core.components.HorizontalLine
import com.example.groceryapp.core.components.PrimaryButton
import com.example.groceryapp.presentation.bottomNavigationBar.BottomNavigation

@Composable
fun ProfileOptionRow(
    iconRes: Int,
    text: String,
    onClick: () -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .height(45.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = iconRes),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(8.dp))
        DescriptionText(
            text = text,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = R.drawable.blackarrow),
            contentDescription = null
        )
    }
    Spacer(modifier = Modifier.height(8.dp))
    HorizontalLine(thickness = 1, color = MaterialTheme.colorScheme.onPrimary)
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun AccountScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigation(navController) },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth().height(70.dp).padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(60.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(16.dp))
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.boy),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth(0.8f).fillMaxHeight(0.8f)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                    ) {
                        DescriptionText(
                            text = "John Youlong",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface,
                            fontWeight = FontWeight.Bold
                        )
                        Image(
                            painter = painterResource(id = R.drawable.pencil),
                            contentDescription = null,
                            modifier = Modifier
                                .size(18.dp)
                                .padding(start = 4.dp)
                        )
                    }
                    DescriptionText(
                        text = "johnyoulong@gmail.com",
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalLine(thickness = 1, color = MaterialTheme.colorScheme.onPrimary)
            Spacer(modifier = Modifier.height(24.dp))

            ProfileOptionRow(iconRes = R.drawable.order, text = "Orders")
            ProfileOptionRow(iconRes = R.drawable.mydetail, text = "My Details")
            ProfileOptionRow(iconRes = R.drawable.locationpin, text = "Delivery Address")
            ProfileOptionRow(iconRes = R.drawable.creditcard, text = "Payment Methods")
            ProfileOptionRow(iconRes = R.drawable.promocard, text = "Promo Card")
            ProfileOptionRow(iconRes = R.drawable.notification, text = "Notifications")
            ProfileOptionRow(iconRes = R.drawable.help, text = "Help")
            ProfileOptionRow(iconRes = R.drawable.about, text = "About")
            Spacer(modifier = Modifier.weight(1f))
            PrimaryButton(
                imageRes = R.drawable.logout,
                text = "Log Out",
                onClick = {  }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewAccount() {
    AccountScreen(navController = rememberNavController())
}
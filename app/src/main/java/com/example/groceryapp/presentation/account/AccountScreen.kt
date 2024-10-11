package com.example.groceryapp.presentation.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.groceryapp.R
import com.example.groceryapp.presentation.bottomNavigationBar.BottomNavigation

@Composable
fun AccountScreen(navController: NavController) {

    Scaffold(
        bottomBar = { BottomNavigation(navController) },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.secondary)
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth().height(70.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(60.dp)
                        .background(color = MaterialTheme.colorScheme.secondary, shape = RoundedCornerShape(16.dp))
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.boy),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .fillMaxHeight(0.8f)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column (
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier

                    ) {
                        Text(
                            text = "John Youlong",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.surface,
                            fontWeight = FontWeight.Bold
                        )
                        Image(
                            painter = painterResource(id = R.drawable.pencil),
                            contentDescription = null,
                            modifier = Modifier.size(18.dp).padding(start = 4.dp)
                        )
                    }
                    Text(
                        text = "johnyoulong@gmail.com",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(modifier = Modifier.background(color = Color.White),thickness = 1.dp)
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.height(45.dp).fillMaxWidth()
            ) {
                Image(
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surface),
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.order),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Orders",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.surface,
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surface),
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.blackarrow),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider(modifier = Modifier.background(color = Color.Gray),thickness = 1.dp)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.height(45.dp).fillMaxWidth()
            ) {
                Image(
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surface),
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.mydetail),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "My Details",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.surface,
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surface),
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.blackarrow),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider(modifier = Modifier.background(color = Color.Gray),thickness = 1.dp)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.height(45.dp).fillMaxWidth()
            ) {
                Image(
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surface),
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.locationpin),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Delivery Address",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.surface
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.blackarrow),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider(modifier = Modifier.background(color = Color.Gray),thickness = 1.dp)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.height(45.dp).fillMaxWidth()
            ) {
                Image(
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surface),
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.creditcard),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Payment Methods",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.surface,
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surface),
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.blackarrow),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider(modifier = Modifier.background(color = Color.Gray),thickness = 1.dp)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.height(45.dp).fillMaxWidth()
            ) {
                Image(
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surface),
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.promocard),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Promo Card",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.surface,
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surface),
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.blackarrow),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider(modifier = Modifier.background(color = Color.Gray),thickness = 1.dp)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.height(45.dp).fillMaxWidth()
            ) {
                Image(
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surface),
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.notification),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Notifications",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.surface,
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surface),
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.blackarrow),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider(modifier = Modifier.background(color = Color.Gray),thickness = 1.dp)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.height(45.dp).fillMaxWidth()
            ) {
                Image(
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surface),
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.help),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Help",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.surface,
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surface),
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.blackarrow),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider(modifier = Modifier.background(color = Color.Gray),thickness = 1.dp)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.height(45.dp).fillMaxWidth()
            ) {
                Image(
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surface),
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.about),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "About",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.surface,
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surface),
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.blackarrow),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider(modifier = Modifier.background(color = Color.Gray),thickness = 1.dp)
            Spacer(modifier = Modifier.height(8.dp))
            Spacer(modifier = Modifier.weight(1f))
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                onClick = {},
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logout),
                    contentDescription = "Button icon",
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    text = "Log out",
                    fontWeight = FontWeight.Bold,
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAccount() {
    AccountScreen(navController = rememberNavController())
}
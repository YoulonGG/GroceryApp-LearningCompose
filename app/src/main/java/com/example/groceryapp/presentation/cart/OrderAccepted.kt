package com.example.groceryapp.presentation.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.groceryapp.R
import com.example.groceryapp.presentation.app.RouteDestinations


@Composable
fun AcceptedOrderScreen(navController: NavController) {
    var showOrderDialog by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier.fillMaxSize().background(color = Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.acceptedorder),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = "Your Order has been Accepted",
            style = MaterialTheme.typography.displaySmall,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = "Your items have been placed and it’s on its way to being processed",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.green1)),
            onClick = { showOrderDialog = true },
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .height(48.dp)
                .fillMaxWidth()
        ) {
            Text(
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
                text = "Track Order",
                fontWeight = FontWeight.Bold,
            )
        }
        if (showOrderDialog) {
            OrderFilter(onDismiss = { showOrderDialog = false }, navController)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navController.navigate(RouteDestinations.CART) },
            text = "Back Home",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(60.dp))
    }
}

@Composable
fun OrderFilter(
    onDismiss: () -> Unit,
    navController: NavController
) {
    Dialog(
        onDismissRequest = { onDismiss() }
    ) {
        Surface(
            modifier = Modifier
                .background(color = Color.White,shape = RoundedCornerShape(15.dp))
                .clip(RoundedCornerShape(15.dp))
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxWidth().padding(16.dp)
            ) {
                Image(
                    modifier = Modifier.size(24.dp).clickable { onDismiss() },
                    painter = painterResource(id = R.drawable.close1),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    modifier = Modifier.size(160.dp).fillMaxWidth().align(alignment = Alignment.CenterHorizontally),
                    painter = painterResource(id = R.drawable.bag),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Oops! Order Failed",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Something went wrong!",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.green1)),
                    onClick = { },
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .height(48.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        fontSize = 16.sp,
                        color = Color.White,
                        text = "Track Order",
                        fontWeight = FontWeight.Bold,
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navController.navigate(RouteDestinations.CART) },
                    text = "Back Home",
                    fontSize = 16.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center)
            }
        }

    }
}




//@Preview(showBackground = true)
//@Composable
//fun PreviewOrderFail() {
//    OrderFilter {  }
//}
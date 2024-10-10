package com.example.groceryapp.presentation.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.groceryapp.R
import com.example.groceryapp.presentation.app.RouteDestinations
import kotlinx.coroutines.launch

data class CartClass(
    val image: Int,
    val name: String,
    val des: String,
    val unitPrice: Double,
    var quantity: Int = 1
) {
    val totalPrice: Double
        get() = unitPrice * quantity
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartList(
    initialItems: List<CartClass> ,
    navController: NavController
) {
    val items = remember { mutableStateListOf<CartClass>().apply { addAll(initialItems) } }
    val bottomSheetState = rememberModalBottomSheetState(false)
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        items(items) { item ->
            CartCard(
                item = item,
                onQuantityChange = { quantity ->
                    val updatedItem = item.copy(quantity = quantity)
                    val index = items.indexOf(item)
                    items[index] = updatedItem
                },
                onRemove = { items.remove(item) },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider(
                color = Color.Gray.copy(alpha = 0.4F),
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.green1)),
                onClick = {
                    scope.launch {
                        bottomSheetState.show()
                    }
                    showBottomSheet = true
                },
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .height(48.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.height(20.dp).width(60.dp))
                    Text(
                        style = androidx.compose.material3.MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        text = "Check Out",
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        modifier = Modifier
                            .height(20.dp)
                            .width(60.dp)
                            .background(color = colorResource(id = R.color.green3)),
                        text = "$99.99",
                        style = androidx.compose.material3.MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
    if (showBottomSheet) {
        BottomSheet(onDismissRequest = {
            scope.launch {
                bottomSheetState.hide()
                showBottomSheet = false
            }
        },navController = navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(onDismissRequest: () -> Unit, navController: NavController) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)
    ModalBottomSheet(
        modifier = Modifier.wrapContentHeight(),
        sheetState = sheetState,
        onDismissRequest = { onDismissRequest() }
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(vertical = 8.dp, horizontal = 16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().height(40.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Checkout",
                    style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
                    color = Color.Black,
                )
                Image(
                    painter = painterResource(id = R.drawable.close1),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = "Delivery",
                    style = androidx.compose.material3.MaterialTheme.typography.bodyLarge,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    textAlign = TextAlign.End,
                    text = "Select Method",
                    style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                    contentDescription = null
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().height(40.dp)
            ){
                Text(
                    text = "Payment",
                    style = androidx.compose.material3.MaterialTheme.typography.bodyLarge,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.creditcard),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                    contentDescription = null
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().height(40.dp)
            ){
                Text(
                    text = "Promo Code",
                    style = androidx.compose.material3.MaterialTheme.typography.bodyLarge,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Pick Discount",
                    style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                    contentDescription = null
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().height(40.dp)
            ){
                Text(
                    text = "Total Cost",
                    style = androidx.compose.material3.MaterialTheme.typography.bodyLarge,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    textAlign = TextAlign.End,
                    text = "$99.99",
                    style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "By placing an order you agree to our",
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
            Text(
                text = "Terms and Conditions",
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                color = Color.Black

            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.green1)),
                onClick = {
                    onDismissRequest()
                    navController.navigate(RouteDestinations.ACCEPTED_ORDER)
                },
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    style = androidx.compose.material3.MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    text = "Place Order",
                    fontWeight = FontWeight.Bold,
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun CartCard(
    item: CartClass,
    onQuantityChange: (Int) -> Unit,
    onRemove: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(horizontal = 10.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .background(color = Color.White)
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .fillMaxHeight()
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = item.name,
                    style = androidx.compose.material3.MaterialTheme.typography.titleMedium,
                    color = Color.Black
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = item.des,
                    style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.minus2),
                        contentDescription = null,
                        modifier = Modifier
                            .size(14.dp)
                            .clickable {
                                if (item.quantity > 1) {
                                    val newQuantity = item.quantity - 1
                                    onQuantityChange(newQuantity)
                                } else {
                                    onRemove()
                                }
                            }
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = item.quantity.toString(),
                        style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Image(
                        painter = painterResource(id = R.drawable.greenadd),
                        contentDescription = null,
                        modifier = Modifier
                            .size(14.dp)
                            .clickable {
                                val newQuantity = item.quantity + 1
                                onQuantityChange(newQuantity)
                            }
                    )
                }
            }
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End,
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.close),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {
                            onRemove()
                        }
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "$${item.totalPrice}",
                    style = androidx.compose.material3.MaterialTheme.typography.titleMedium,
                    color = Color.Black
                )
            }
        }
    }
}



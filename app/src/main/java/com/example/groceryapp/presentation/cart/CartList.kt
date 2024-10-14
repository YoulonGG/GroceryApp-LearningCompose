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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.groceryapp.R
import com.example.groceryapp.core.components.DescriptionText
import com.example.groceryapp.core.components.HeaderText
import com.example.groceryapp.core.components.PrimaryButton
import com.example.groceryapp.presentation.app.RouteDestinations
import kotlinx.coroutines.launch
import java.util.Locale

data class CartClass(
    val image: Int,
    val name: String,
    val des: String,
    val unitPrice: Double,
    var quantity: Int = 1
) {
    val totalPrice: Double get() = unitPrice * quantity
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartList(
    initialItems: List<CartClass>,
    navController: NavController
) {
    val items = remember { mutableStateListOf<CartClass>().apply { addAll(initialItems) } }
    val bottomSheetState = rememberModalBottomSheetState(false)
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

    val totalAmount = calculateTotal(items)

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

        if (items.isNotEmpty()) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
                PrimaryButton(
                    text = "Checkout",
                    onClick = { showBottomSheet = true },
                    endText = String.format(Locale.US, "%.2f", totalAmount, "$"),
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
    if (showBottomSheet) {
        BottomSheet(onDismissRequest = {
            scope.launch {
                bottomSheetState.hide()
                showBottomSheet = false
            }
        }, navController = navController)
    }
}
private fun calculateTotal(items: List<CartClass>): Double {
    return items.sumOf { it.unitPrice * it.quantity }
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
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().height(40.dp)
            ) {
                HeaderText(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                    text = "Checkout",
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
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).height(40.dp)
            ){
                DescriptionText(
                    text = "Delivery",
                )
                Spacer(modifier = Modifier.weight(1f))
                DescriptionText(
                    textAlign = TextAlign.End,
                    text = "Select Method",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
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
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).height(40.dp)
            ){
                DescriptionText(
                    text = "Payment",
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
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).height(40.dp)
            ){
                DescriptionText(
                    text = "Promo Code",
                )
                Spacer(modifier = Modifier.weight(1f))
                DescriptionText(
                    text = "Pick Discount",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
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
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).height(40.dp)
            ){
                DescriptionText(
                    text = "Total Cost",
                )
                Spacer(modifier = Modifier.weight(1f))
                DescriptionText(
                    textAlign = TextAlign.End,
//                    text = String.format(Locale.US, "%.2f", totalAmount, "$"),
                    text = "00.00$",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            DescriptionText(
                text = "By placing an order you agree to our",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(start = 16.dp)
            )
            DescriptionText(
                text = "Terms and Conditions",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            PrimaryButton(
                text = "Place Order",
                onClick = { navController.navigate(RouteDestinations.ACCEPTED_ORDER) },
            )
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
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = item.des,
                    style = MaterialTheme.typography.bodyMedium,
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
                        style = MaterialTheme.typography.bodyMedium,
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
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black
                )
            }
        }
    }
}



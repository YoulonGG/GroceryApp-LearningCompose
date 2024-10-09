package com.example.groceryapp.presentation.cart

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groceryapp.R

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


@Composable
fun CartList(initialItems: List<CartClass>) {
    val items = remember { mutableStateListOf<CartClass>().apply { addAll(initialItems) } }

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
                onRemove = {
                    items.remove(item)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
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
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = item.des,
                    fontSize = 14.sp,
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
                        fontSize = 16.sp,
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
                    fontSize = 18.sp,
                    color = Color.Black
                )
            }
        }
    }
}


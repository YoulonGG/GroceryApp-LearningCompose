package com.example.groceryapp.presentation.shop

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groceryapp.R

data class ExclusiveItem(
    val imageResId: Int,
    val name: String,
    val des: String,
    val price: String
)

@Composable
fun ExclusiveHorizontalItemList(
    modifier: Modifier = Modifier,
    items: List<ExclusiveItem>
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp, top = 8.dp)
    ) {
        items(items) { item ->
            ItemCard(item = item)
        }
    }
}

@Composable
fun ItemCard(item: ExclusiveItem) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .height(180.dp)
            .width(130.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(0.5.dp,Color.Gray.copy(alpha = 0.6F)),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)
        ) {
            Image(
                painter = painterResource(id = item.imageResId),
                contentDescription = null,
                modifier = Modifier.size(80.dp).fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = item.name,
                fontSize = 16.sp,
                maxLines = 1,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Start).fillMaxWidth()
            )
            Text(
                modifier = Modifier.align(Alignment.Start).fillMaxWidth(),
                text = item.des,
                fontSize = 12.sp,
                maxLines = 1,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = item.price,
                    fontSize = 16.sp,
                    maxLines = 1,
                    color = Color.Black
                )
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(30.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(color = colorResource(id = R.color.green1))
                        .clickable { }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.add),
                        contentDescription = null,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewItemCard() {
    ItemCard(
        item = ExclusiveItem(
            imageResId = R.drawable.apple,
            name = "Sample Item",
            des = "Sample Description",
            price = "00.00$"
        )
    )
}


package com.example.groceryapp.presentation.explore.beverages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groceryapp.R

data class BeveragesClass(
    val image: Int,
    val name: String,
    val des: String,
    val price: String
)

@Composable
fun BeverageList(items: List<BeveragesClass>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        items(items.chunked(2), key = { it.hashCode() }) { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                rowItems.forEach { item ->
                    BeverageCard(item = item, modifier = Modifier.weight(1f))
                }
                if (rowItems.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
fun BeverageCard(item: BeveragesClass, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(210.dp)
            .padding(horizontal = 10.dp, vertical = 10.dp)
        .border(1.dp, color = colorResource(id = R.color.green1), RoundedCornerShape(10.dp)),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .background(color = Color.White)
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .fillMaxWidth()
                    .aspectRatio(1f),
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
                    color = Color.Black,)
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(color = colorResource(id = R.color.green1))
                        .clickable {}
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
fun PreviewBeveragesCard() {
    BeverageCard(
        item = BeveragesClass(
            image = R.drawable.apple,
            name = "Sample Item",
            des = "Sample Description",
            price = "00.00$"
        )
    )
}


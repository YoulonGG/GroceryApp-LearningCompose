package com.example.groceryapp.presentation.explore.beverages


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.groceryapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BeveragesScreen(navController: NavController) {

    val beverages = listOf(
        BeveragesClass(R.drawable.b1, "Diet Coke", "355ML, Price", "1.99$"),
        BeveragesClass(R.drawable.b2, "Sprite", "325ML, Price", "1.50$"),
        BeveragesClass(R.drawable.b3, "Apple & Grape Juice", "2L, Price", "15.99$"),
        BeveragesClass(R.drawable.b4, "Orange Juice", "2L, Price", "15.99$"),
        BeveragesClass(R.drawable.b5, "Coca Cola", "325ML, Price", "4.99$"),
        BeveragesClass(R.drawable.b6, "Pepsi", "335ML, Price", "4.99$"),
    )

    var showFilterDialog by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.background(color = Color.White),
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 16.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp).clickable { navController.popBackStack() }
                        )
                        Text(
                            text = "Beverages",
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.filter),
                            contentDescription = "Settings",
                            modifier = Modifier.size(24.dp).clickable {  showFilterDialog = true }
                        )
                        if (showFilterDialog) {
                            Filter(onDismiss = { showFilterDialog = false })
                        }
                    }
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
            Box(modifier = Modifier.padding(horizontal = 8.dp)) {
                BeverageList(items = beverages)
            }
        }
    }
}

@Composable
fun Filter(
    onDismiss: () -> Unit,
) {
    Dialog(
        onDismissRequest = { onDismiss() }
    ) {
        var categoryEggs by remember { mutableStateOf(false) }
        var categoryNoodle by remember { mutableStateOf(false) }
        var categoryChips by remember { mutableStateOf(false) }
        var categoryFastFood by remember { mutableStateOf(false) }

        var brand1 by remember { mutableStateOf(false) }
        var brand2 by remember { mutableStateOf(false) }
        var brand3 by remember { mutableStateOf(false) }
        var brand4 by remember { mutableStateOf(false) }

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
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp).clickable { onDismiss() }
                    )
                    Text(
                        text = "Filters",
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.size(24.dp))
                }
                Spacer(modifier = Modifier.height(32.dp))
                Column(
                    modifier = Modifier
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Categories",
                        fontSize = 22.sp,
                        color = Color.Black,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth().height(35.dp)
                    ) {
                        Checkbox(
                            colors = CheckboxDefaults.colors(
                                checkedColor = colorResource(id = R.color.green1),
                                uncheckedColor = Color.Gray
                            ),
                            checked = categoryEggs,
                            onCheckedChange = { categoryEggs = it },
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Eggs", fontSize = 15.sp, color = if (categoryEggs) colorResource(id = R.color.green1) else Color.Black)
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth().height(35.dp)
                    ) {
                        Checkbox(
                            colors = CheckboxDefaults.colors(
                                checkedColor = colorResource(id = R.color.green1),
                                uncheckedColor = Color.Gray
                            ),
                            checked = categoryNoodle,
                            onCheckedChange = { categoryNoodle = it }
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Noodle & Pasta", fontSize = 15.sp, color = if (categoryNoodle) colorResource(id = R.color.green1) else Color.Black)
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth().height(35.dp)
                    ) {
                        Checkbox(
                            colors = CheckboxDefaults.colors(
                                checkedColor = colorResource(id = R.color.green1),
                                uncheckedColor = Color.Gray
                            ),
                            checked = categoryChips,
                            onCheckedChange = { categoryChips = it }
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Chips & Crispy", fontSize = 15.sp, color = if (categoryChips) colorResource(id = R.color.green1) else Color.Black)
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth().height(35.dp)
                    ) {
                        Checkbox(
                            colors = CheckboxDefaults.colors(
                                checkedColor = colorResource(id = R.color.green1),
                                uncheckedColor = Color.Gray
                            ),
                            checked = categoryFastFood,
                            onCheckedChange = { categoryFastFood = it }
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Fast Food", fontSize = 15.sp, color = if (categoryFastFood) colorResource(id = R.color.green1) else Color.Black)
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Brand",
                    fontSize = 22.sp,
                    color = Color.Black,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().height(35.dp)
                ) {
                    Checkbox(
                        colors = CheckboxDefaults.colors(
                            checkedColor = colorResource(id = R.color.green1),
                            uncheckedColor = Color.Gray
                        ),
                        checked = brand1,
                        onCheckedChange = { brand1 = it },
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "Eggs", fontSize = 15.sp, color = if (brand1) colorResource(id = R.color.green1) else Color.Black)
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().height(35.dp)
                ) {
                    Checkbox(
                        colors = CheckboxDefaults.colors(
                            checkedColor = colorResource(id = R.color.green1),
                            uncheckedColor = Color.Gray
                        ),
                        checked = brand2,
                        onCheckedChange = { brand2 = it }
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "Noodle & Pasta", fontSize = 15.sp, color = if (brand2) colorResource(id = R.color.green1) else Color.Black)
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().height(35.dp)
                ) {
                    Checkbox(
                        colors = CheckboxDefaults.colors(
                            checkedColor = colorResource(id = R.color.green1),
                            uncheckedColor = Color.Gray
                        ),
                        checked = brand3,
                        onCheckedChange = { brand3 = it }
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "Ifad", fontSize = 15.sp, color = if (brand3) colorResource(id = R.color.green1) else Color.Black)
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().height(35.dp)
                ) {
                    Checkbox(
                        colors = CheckboxDefaults.colors(
                            checkedColor = colorResource(id = R.color.green1),
                            uncheckedColor = Color.Gray
                        ),
                        checked = brand4,
                        onCheckedChange = { brand4 = it }
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Kazi Farmas",
                        fontSize = 15.sp,
                        color = if (brand4) colorResource(id = R.color.green1) else Color.Black
                    )
                }
                Spacer(modifier = Modifier.height(42.dp))
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.green1)),
                    onClick = {},
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .height(48.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        fontSize = 16.sp,
                        color = Color.White,
                        text = "Apply Filter",
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun FilterBeverages() {
    BeveragesScreen(navController = rememberNavController())
}
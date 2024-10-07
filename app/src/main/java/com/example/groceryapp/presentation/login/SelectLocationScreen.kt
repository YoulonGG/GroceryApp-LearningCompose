package com.example.groceryapp.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.groceryapp.R
import com.example.groceryapp.presentation.app.RouteDestinations

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectLocationScreen(navController: NavController) {
    val selectZone = arrayOf("Cambodia", "India", "China", "USA", "Thailand")
    var expandedZone by remember { mutableStateOf(false) }
    var selectedText1 by remember { mutableStateOf(selectZone[0]) }

    val selectArea = arrayOf("City", "Countryside")
    var expandedArea by remember { mutableStateOf(false) }
    var selectedText2 by remember { mutableStateOf(selectArea[0]) }

    val colors = TextFieldDefaults.colors(
        focusedContainerColor = Color.White,
        unfocusedContainerColor = Color.White,
        disabledContainerColor = Color.White,
        focusedIndicatorColor = Color.White,
        unfocusedIndicatorColor = Color.White,
        disabledIndicatorColor = Color.Transparent,
    )

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        Image(
            painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 32.dp)
                .width(24.dp)
                .height(24.dp)
                .clickable { navController.popBackStack() }
        )
        Image(
            painter = painterResource(id = R.drawable.location),
            contentDescription = null,
            modifier = Modifier
                .width(180.dp)
                .height(150.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 36.dp),
            text = "Select your location",
            color = Color.Black,
            fontSize = 22.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 36.dp),
            text = "Switch on your location to stay tuned with what's happening in your area",
            color = Color.Gray,
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(52.dp))
        Text(
            text = "Your Zone",
            color = Color.Gray,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 30.dp)
        )
        ExposedDropdownMenuBox(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(50.dp),
            expanded = expandedZone,
            onExpandedChange = { expandedZone = !expandedZone }
        ) {
            TextField(
                colors = colors,
                value = selectedText1,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedZone)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expandedZone,
                onDismissRequest = { expandedZone = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                selectZone.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedText1 = item
                            expandedZone = false
                        }
                    )
                }
            }
        }
        Text(
            text = "Your Area",
            color = Color.Gray,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 30.dp)
        )
        ExposedDropdownMenuBox(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(50.dp),
            expanded = expandedArea,
            onExpandedChange = { expandedArea = !expandedArea }
        ) {
            TextField(
                colors = colors,
                value = selectedText2,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedArea)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expandedArea,
                onDismissRequest = { expandedArea = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                selectArea.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedText2 = item
                            expandedArea = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.green1)),
            onClick = { navController.navigate(RouteDestinations.SIGN_IN) },
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .padding(horizontal = 36.dp)
                .height(45.dp)
                .fillMaxWidth()
        ) {
            Text(
                fontSize = 16.sp,
                color = Color.White,
                text = "Submit",
                fontWeight = FontWeight.Bold,
            )
        }
        Spacer(modifier = Modifier.height(42.dp))
    }
}





@Preview(showBackground = true)
@Composable
fun PreviewSelectMap() {
    SelectLocationScreen(navController = rememberNavController())
}
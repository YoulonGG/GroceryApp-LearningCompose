package com.example.groceryapp.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.groceryapp.R
import com.example.groceryapp.presentation.app.RouteDestinations
import kotlinx.coroutines.flow.callbackFlow

@Composable
fun PhoneNumberScreen(navController: NavController) {

    var phoneNumber by remember { mutableStateOf("") }
    val colors = TextFieldDefaults.colors(
        focusedContainerColor = Color.White,
        unfocusedContainerColor = Color.White,
        disabledContainerColor = Color.White,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp)
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        Image(
            painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .clickable { navController.popBackStack() }
        )
        Spacer(modifier = Modifier.height(62.dp))
        Text(
            text = "Enter your mobile number",
            color = Color.Black,
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Mobile Number",
            color = Color.Gray,
            fontSize = 14.sp
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically, // This is fine
        ) {
            Image(
                painter = painterResource(id = R.drawable.cam),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
            )
            Text(
                text = "+855",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.padding(start = 10.dp),
                textAlign = TextAlign.Center
            )
            BasicTextField(
//                colors = colors,
                value = phoneNumber,
                onValueChange = { newValue ->
                    if (newValue.all { it.isDigit() } || newValue.isEmpty()) {
                        phoneNumber = newValue
                    }
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
                modifier = Modifier.weight(1f).padding(start = 8.dp)
//                modifier = Modifier
//                    .background(Color.White, RoundedCornerShape(8.dp))
//                    .border(BorderStroke(1.dp, if (phoneNumber.isNotEmpty()) Color.Blue else Color.Gray), RoundedCornerShape(8.dp))
//                    .padding(12.dp)
//                    .fillMaxWidth()
            )
        }
        HorizontalDivider(modifier = Modifier.background(color = Color.Black), thickness = 1.dp)
        Spacer(modifier = Modifier.weight(1f))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(color = colorResource(id = R.color.green1))
                .clickable { navController.navigate(RouteDestinations.OTP) }
                .align(Alignment.End)
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                contentDescription = null,
                )
        }
        Spacer(modifier = Modifier.height(60.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPhoneNumberInputScreen() {
    PhoneNumberScreen(navController = rememberNavController())
}



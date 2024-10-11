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
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.ColorFilter
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

@Composable
fun PhoneNumberScreen(navController: NavController) {

    var phoneNumber by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.secondary)
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        Image(
            colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.surface),
            painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 16.dp)
                .size(24.dp)
                .clickable { navController.popBackStack() }
        )
        Spacer(modifier = Modifier.height(62.dp))
        Text(
            modifier = Modifier.fillMaxWidth(). padding(horizontal = 16.dp),
            text = "Enter your mobile number",
            color = MaterialTheme.colorScheme.surface,
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            modifier = Modifier.fillMaxWidth(). padding(horizontal = 16.dp),
            text = "Mobile Number",
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.titleMedium
        )
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.cam),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
            )
            Text(
                text = "+855",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.surface,
                modifier = Modifier.padding(start = 10.dp),
                textAlign = TextAlign.Center
            )
            BasicTextField(
                value = phoneNumber,
                onValueChange = { newValue ->
                    if (newValue.all { it.isDigit() } || newValue.isEmpty()) {
                        phoneNumber = newValue
                        if (isError && newValue.isNotEmpty()) {
                            isError = false
                        }
                    }
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                textStyle = TextStyle(fontSize = 18.sp, color = MaterialTheme.colorScheme.surface),
                modifier = Modifier.weight(1f).padding(start = 8.dp)
            )
        }
        HorizontalDivider(modifier = Modifier
            .padding(horizontal = 16.dp)
            .background(color = MaterialTheme.colorScheme.surface),
            thickness = 1.dp)
        if (isError) {
            Text(
                text = "Please enter a valid phone number.",
                color = Color.Red,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(color = MaterialTheme.colorScheme.primary)
                .clickable {
                if (phoneNumber.length >= 8) {
                    navController.navigate(RouteDestinations.OTP)
                } else {
                    isError = true
                }
            }.align(Alignment.End)
        ) {
            Image(
                painter = painterResource(id = R.drawable.white_arrow),
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



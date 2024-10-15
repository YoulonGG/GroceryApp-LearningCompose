package com.example.groceryapp.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.groceryapp.R
import com.example.groceryapp.core.components.BackAndBackground
import com.example.groceryapp.core.components.DescriptionText
import com.example.groceryapp.core.components.HeaderText
import com.example.groceryapp.core.components.TextWithNavigateButton
import com.example.groceryapp.presentation.app.RouteDestinations

@Composable
fun OTPScreen(navController: NavController) {
    val otpDigits = remember { List(4) { mutableStateOf("") } }
    val colors = TextFieldDefaults.colors(
        focusedContainerColor = Color.White,
        unfocusedContainerColor = Color.White,
        disabledContainerColor = Color.White,
        focusedIndicatorColor = Color.Gray,
        unfocusedIndicatorColor = Color.Gray,
        disabledIndicatorColor = Color.Transparent,
        focusedTextColor = Color.Black,
        unfocusedTextColor = Color.Black
    )
    val focusRequesters = List(4) { FocusRequester() }

    BackAndBackground(
        imageRes = R.drawable.baseline_arrow_back_ios_new_24,
        onClick = {  navController.popBackStack()  }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(150.dp))
            HeaderText(
                text = "Enter 4-digits code",
                modifier = Modifier.padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            DescriptionText(
                text = "Code",
                modifier = Modifier.padding(start = 16.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (i in 0..3) {
                    TextField(
                        value = otpDigits[i].value,
                        onValueChange = { newValue ->
                            if (newValue.length <= 1 && newValue.all { it.isDigit() }) {
                                otpDigits[i].value = newValue
                                if (newValue.isNotEmpty() && i < 3) {
                                    focusRequesters[i + 1].requestFocus()
                                }
                            } else if (newValue.isEmpty() && i > 0) {
                                focusRequesters[i - 1].requestFocus()
                            }
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                        modifier = Modifier
                            .size(70.dp)
                            .focusRequester(focusRequesters[i]),
                        textStyle = TextStyle(
                            fontSize = 32.sp,
                            textAlign = TextAlign.Center,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        ),
                        singleLine = true,
                        maxLines = 1,
                        colors = colors
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            TextWithNavigateButton(
                text = "Resend Code",
                imageRes = R.drawable.white_arrow,
                onClick = { navController.navigate(RouteDestinations.SELECT_LOCATION_SCREEN) }
            )

            Spacer(modifier = Modifier.height(60.dp))
        }
    }
}




@Preview(showBackground = true)
@Composable
fun Preview() {
    OTPScreen(navController = rememberNavController())
}

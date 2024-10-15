package com.example.groceryapp.presentation.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.groceryapp.R
import com.example.groceryapp.core.components.BackAndBackground
import com.example.groceryapp.core.components.DescriptionText
import com.example.groceryapp.core.components.HeaderText
import com.example.groceryapp.core.components.HorizontalLine
import com.example.groceryapp.core.components.NavigateButton
import com.example.groceryapp.core.components.SelectFlagPhoneNumber
import com.example.groceryapp.presentation.app.RouteDestinations

@Composable
fun PhoneNumberScreen(navController: NavController) {

    var phoneNumber by remember { mutableStateOf("") }

    BackAndBackground(
        imageRes = R.drawable.baseline_arrow_back_ios_new_24,
        onClick = {  navController.popBackStack()  }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(150.dp))
            HeaderText(
                text = "Enter your Mobile Number",
                modifier = Modifier.padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            DescriptionText(
                text = "Mobile Number",
                modifier = Modifier.padding(start = 16.dp)
            )
            SelectFlagPhoneNumber(
                imageRes = R.drawable.cam,
                countryCode = "+855",
                onClick = {  },
                phoneNumber = phoneNumber,
                onPhoneNumberChange = { phoneNumber = it }
            )
            HorizontalLine(thickness = 1, color = MaterialTheme.colorScheme.onPrimary)
            Spacer(modifier = Modifier.weight(1f))
            NavigateButton(
                modifier = Modifier.align(Alignment.End).padding(end = 16.dp),
                imageRes = R.drawable.white_arrow,
                onClick = { navController.navigate(RouteDestinations.OTP) }
            )
            Spacer(modifier = Modifier.height(60.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPhoneNumberInputScreen() {
    PhoneNumberScreen(navController = rememberNavController())
}



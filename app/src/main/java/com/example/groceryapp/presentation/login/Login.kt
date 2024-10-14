package com.example.groceryapp.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.groceryapp.R
import com.example.groceryapp.core.components.HeaderText
import com.example.groceryapp.core.components.HorizontalLine
import com.example.groceryapp.core.components.PrimaryButton
import com.example.groceryapp.core.components.SelectFlagPhoneNumber
import com.example.groceryapp.presentation.app.RouteDestinations

@Composable
fun LoginScreen(navController: NavHostController) {
    var showBottomSheet by remember { mutableStateOf(false) }
    var selectedCountry by remember { mutableStateOf("Cambodia") }
    var selectedCountryCode by remember { mutableStateOf("+855") }
    var selectedImageRes by remember { mutableIntStateOf(R.drawable.cam) }

    var phoneNumber by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize().background(color = Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg1),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
        )
        Column(
            modifier = Modifier
                .padding(top = 360.dp)
        ) {
            HeaderText(
                text = "Get your groceries \nwith nectar",
                modifier = Modifier.padding(start = 16.dp)
            )
            SelectFlagPhoneNumber(
                imageRes = selectedImageRes,
                countryCode = selectedCountryCode,
                onClick = { showBottomSheet = true },
                phoneNumber = phoneNumber,
                onPhoneNumberChange = { phoneNumber = it }
            )
            HorizontalLine(color = MaterialTheme.colorScheme.onPrimary, thickness = 1)
            Spacer(modifier = Modifier.height(16.dp))
            PrimaryButton(
                text = "Login",
                onClick = {navController.navigate(RouteDestinations.PHONE_NUMBER)})
            Spacer(modifier = Modifier.height(42.dp))
            Text(
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                text = "Or connect with social media",
                modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(16.dp))
            PrimaryButton(
                text = "Continue with Google",
                imageRes = R.drawable.googlesymbol,
                backgroundColor = MaterialTheme.colorScheme.background,
                onClick = { }
            )
            Spacer(modifier = Modifier.height(10.dp))
            PrimaryButton(
                text = "Continue with Facebook",
                imageRes = R.drawable.googlesymbol,
                backgroundColor = MaterialTheme.colorScheme.onBackground,
                onClick = { }
            )
        }
    }
    if (showBottomSheet) {
        BottomSheet(
            onDismissRequest = { showBottomSheet = false },
            onItemSelected = { country, countryCode, imageRes ->
                selectedCountry = country
                selectedCountryCode = countryCode
                selectedImageRes = imageRes
                showBottomSheet = false
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(onDismissRequest: () -> Unit, onItemSelected: (String, String, Int) -> Unit) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)

    ModalBottomSheet(
        modifier = Modifier.fillMaxHeight(),
        sheetState = sheetState,
        onDismissRequest = { onDismissRequest() }
    ) {
        CountryRow(
            imageRes = R.drawable.cam,
            countryName = "Cambodia",
            countryCode = "+855",
            onRowClick = { onItemSelected("Cambodia", "+855", R.drawable.cam) }
        )
        CountryRow(
            imageRes = R.drawable.india,
            countryName = "India",
            countryCode = "+91",
            onRowClick = { onItemSelected("India", "+91", R.drawable.india) }
        )
        CountryRow(
            imageRes = R.drawable.china,
            countryName = "China",
            countryCode = "+86",
            onRowClick = { onItemSelected("China", "+86", R.drawable.china) }
        )
        CountryRow(
            imageRes = R.drawable.vn,
            countryName = "Vietnam",
            countryCode = "+84",
            onRowClick = { onItemSelected("Vietnam", "+84", R.drawable.vn) }
        )
        CountryRow(
            imageRes = R.drawable.portugal,
            countryName = "Portugal",
            countryCode = "+351",
            onRowClick = { onItemSelected("Vietnam", "+351", R.drawable.portugal) }
        )
        CountryRow(
            imageRes = R.drawable.england,
            countryName = "England",
            countryCode = "+44",
            onRowClick = { onItemSelected("England", "+44", R.drawable.england) }
        )
    }
}

@Composable
fun CountryRow(imageRes: Int, countryName: String, countryCode: String, onRowClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .padding(horizontal = 16.dp)
            .clickable(onClick = onRowClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.size(30.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = countryName,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = countryCode,
            color = Color.Black,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLogin() {
    LoginScreen(navController = rememberNavController())
}

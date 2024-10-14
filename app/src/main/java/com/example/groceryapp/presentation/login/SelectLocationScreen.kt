package com.example.groceryapp.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.groceryapp.R
import com.example.groceryapp.core.components.DescriptionText
import com.example.groceryapp.core.components.HeaderText
import com.example.groceryapp.core.components.PrimaryButton
import com.example.groceryapp.presentation.app.RouteDestinations

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectLocationScreen(navController: NavController) {
    val selectZone = arrayOf("Select a Zone", "Cambodia", "India", "China", "USA", "Thailand")
    var expandedZone by remember { mutableStateOf(false) }
    var selectedZoneIndex by remember { mutableIntStateOf(0) }

    val selectArea = arrayOf("Select an Area", "City", "Countryside")
    var expandedArea by remember { mutableStateOf(false) }
    var selectedAreaIndex by remember { mutableIntStateOf(0) }
    var errorMessage by remember { mutableStateOf("") }

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
        Spacer(modifier = Modifier.height(70.dp))
        Image(
            painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 16.dp)
                .size(24.dp)
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
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeaderText(
                text = "Select your location",
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(horizontal = 16.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(10.dp))
            DescriptionText(
                modifier = Modifier.padding(16.dp),
                text = "Switch on your location to stay tuned with what's happening in your area",
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(52.dp))
        DescriptionText(
            text = "Your Zone",
            modifier = Modifier.padding(start = 16.dp)
        )
        ExposedDropdownMenuBox(
            modifier = Modifier.fillMaxWidth(),
            expanded = expandedZone,
            onExpandedChange = { expandedZone = !expandedZone }
        ) {
            TextField(
                colors = colors,
                value = selectZone[selectedZoneIndex],
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedZone)
                },
                modifier = Modifier.fillMaxWidth().menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expandedZone,
                onDismissRequest = { expandedZone = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                selectZone.forEachIndexed { index, item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedZoneIndex = index
                            expandedZone = false
                            errorMessage = ""
                        }
                    )
                }
            }
        }
        DescriptionText(
            text = "Your Area",
            modifier = Modifier.padding(start = 16.dp)
        )
        ExposedDropdownMenuBox(
            modifier = Modifier.fillMaxWidth(),
            expanded = expandedArea,
            onExpandedChange = { expandedArea = !expandedArea }
        ) {
            TextField(
                colors = colors,
                value = selectArea[selectedAreaIndex],
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedArea)
                },
                modifier = Modifier.fillMaxWidth().menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expandedArea,
                onDismissRequest = { expandedArea = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                selectArea.forEachIndexed { index, item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedAreaIndex = index
                            expandedArea = false
                            errorMessage = ""
                        }
                    )
                }
            }
        }
        if (errorMessage.isNotEmpty()) {
            DescriptionText(
                text = errorMessage,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.error
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        PrimaryButton(
            text = "Submit",
            onClick = {
                if (selectedZoneIndex > 0 && selectedAreaIndex > 0) {
                    navController.navigate(RouteDestinations.SIGN_IN)
                } else {
                    errorMessage = "Please select both zone and area."
                }
            }
        )
        Spacer(modifier = Modifier.height(60.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSelectMap() {
    SelectLocationScreen(navController = rememberNavController())
}
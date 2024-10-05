package com.example.groceryapp.presentation.Login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.groceryapp.R

@Composable
fun WelcomeScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.welcome),
            modifier = Modifier.fillMaxSize(),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxSize().padding(top = 500.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.carrot),
                contentDescription = "Background Image",
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                )
            Text(
                fontSize = 42.sp,
                color = Color.White,
                text = "Welcome \n to Our Store",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 42.dp)
            )
            Text(
                fontSize = 14.sp,
                color = Color.White,
                    text = "Get your groceries in as fast as one hour",
                modifier = Modifier.padding(horizontal = 42.dp).padding(top = 8.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.green1)),
                onClick = {navController.navigate("login")},
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .padding(horizontal = 36.dp)
                    .height(48.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    fontSize = 16.sp,
                    color = Color.White,
                    text = "Get Start",
                    fontWeight = FontWeight.Bold,
                )
            }
            Spacer(modifier = Modifier.height(42.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWelcome() {
    WelcomeScreen(navController = rememberNavController())
}



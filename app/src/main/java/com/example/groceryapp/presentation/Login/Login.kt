package com.example.groceryapp.presentation.Login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.groceryapp.R
import com.example.groceryapp.presentation.App.RouteDestinations

@Composable
fun LoginScreen(navController: NavHostController) {

    var showBottomSheet by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize()
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
                .padding(horizontal = 32.dp)
        ) {
            Text(
                fontSize = 22.sp,
                color = Color.Black,
                text = "Get your groceries \nwith nectar",
                fontWeight = FontWeight.Bold,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .height(56.dp)
                    .clickable {
                        showBottomSheet = true
                    }

            ) {
                Image(
                    painter = painterResource(id = R.drawable.cam),
                    contentDescription = null,
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                )
                Text(text = "+855", fontSize = 16.sp, color = Color.Black, modifier = Modifier.padding(start = 10.dp))
                if (showBottomSheet) {
                    BottomSheet(navController)
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                color = Color.Gray,
                text = "Or connect with social media",
                modifier = Modifier
                    .padding(start = 8.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(42.dp))
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.blue1)),
                onClick = {},
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.googlesymbol),
                    contentDescription = null,
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    fontSize = 14.sp,
                    color = Color.White,
                    text = "Continue with Google",
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.blue2)),
                onClick = {},
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.facebooklogo),
                    contentDescription = null,
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    fontSize = 14.sp,
                    color = Color.White,
                    text = "Continue with Facebook",
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(navController: NavHostController) {

    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
    )

    ModalBottomSheet(
        modifier = Modifier.fillMaxHeight(),
        sheetState = sheetState,
        onDismissRequest = { showBottomSheet = false }
    ) {
        Row(
            modifier = Modifier
                .clickable { navController.navigate(RouteDestinations.PHONE_NUMBER) }
                .fillMaxWidth()
                .height(45.dp)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.cam),
                contentDescription = null,
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Cambodia", fontSize = 16.sp, color = Color.Black, modifier = Modifier.weight(1f))
            Text(text = "+885", color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Image(
                painter = painterResource(id = R.drawable.cam),
                contentDescription = null,
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Cambodia", fontSize = 16.sp, color = Color.Black, modifier = Modifier.weight(1f))
            Text(text = "+885", color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Image(
                painter = painterResource(id = R.drawable.cam),
                contentDescription = null,
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Cambodia", fontSize = 16.sp, color = Color.Black, modifier = Modifier.weight(1f))
            Text(text = "+885", color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Image(
                painter = painterResource(id = R.drawable.cam),
                contentDescription = null,
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Cambodia", fontSize = 16.sp, color = Color.Black, modifier = Modifier.weight(1f))
            Text(text = "+885", color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLogin() {
    LoginScreen(navController = rememberNavController())
}

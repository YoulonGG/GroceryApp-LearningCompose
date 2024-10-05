package com.example.groceryapp.presentation.Login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.groceryapp.R

@Composable
fun SignInScreen(navController: NavController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    val colors = TextFieldDefaults.colors(
        focusedContainerColor = Color.White,
        unfocusedContainerColor = Color.White,
        disabledContainerColor = Color.White,
        focusedIndicatorColor = Color.Gray,
        unfocusedIndicatorColor = Color.Gray,
        disabledIndicatorColor = Color.White
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(150.dp))
        Image(
            painter = painterResource(id = R.drawable.orangecarrot),
            contentDescription = null,
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(42.dp))
        Text(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 36.dp),
            text = "Log in",
            color = Color.Black,
            fontSize = 22.sp,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 36.dp),
            text = "Enter your email and password",
            color = Color.Gray,
            fontSize = 14.sp,
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 36.dp),
            text = "Email",
            color = Color.Gray,
            fontSize = 16.sp,
        )
        OutlinedTextField(
            modifier = Modifier
                .height(48.dp)
                .padding(horizontal = 36.dp)
                .fillMaxWidth(),
            singleLine = true,
            colors = colors,
            value = email,
            onValueChange = {email = it},
            textStyle = TextStyle(fontSize = 16.sp),
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 36.dp),
            text = "Password",
            color = Color.Gray,
            fontSize = 16.sp,
        )
        OutlinedTextField(
            modifier = Modifier
                .height(48.dp)
                .padding(horizontal = 36.dp)
                .fillMaxWidth(),
            singleLine = true,
            colors = colors,
            value = password,
            onValueChange = { password = it },
            textStyle = TextStyle(fontSize = 16.sp),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisible) R.drawable.baseline_remove_red_eye_24 else R.drawable.baseline_remove_red_eye_24
                IconButton(onClick = {
                    passwordVisible = !passwordVisible
                }) {
                    Image(
                        painter = painterResource(id = image),
                        contentDescription = null
                    )
                }
            },
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier
                .padding(horizontal = 36.dp)
                .fillMaxWidth(),
            text = "Forget your password?",
            fontSize = 14.sp,
            color = Color.Black,
            textAlign = TextAlign.End
        )
        Spacer(modifier = Modifier.height(42.dp))
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.green1)),
            onClick = {navController.navigate("shop")},
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .padding(horizontal = 36.dp)
                .height(48.dp)
                .fillMaxWidth()
        ) {
            Text(
                fontSize = 16.sp,
                color = Color.White,
                text = "Login",
                fontWeight = FontWeight.Bold,
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Don't have an account?",
                fontSize = 14.sp,
                color = Color.Black
            )
            Text(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .clickable { navController.navigate("signupScreen") },
                text = "Sign Up",
                fontSize = 14.sp,
                color = colorResource(id = R.color.green1)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignIn() {
    SignInScreen(navController = rememberNavController())
}
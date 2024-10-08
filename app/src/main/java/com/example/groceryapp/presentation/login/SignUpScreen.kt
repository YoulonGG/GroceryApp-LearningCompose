package com.example.groceryapp.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.groceryapp.R

@Composable
fun SignUpScreen(navController: NavController) {

    var signupEmail by remember { mutableStateOf("") }
    var signupUsername by remember { mutableStateOf("") }
    var signupPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().background(color = Color.White)
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
            text = "Sign Up",
            color = Color.Black,
            fontSize = 22.sp,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 36.dp),
            text = "Enter your credentials to continue",
            color = Color.Gray,
            fontSize = 14.sp,
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 36.dp),
            text = "Username",
            color = Color.Gray,
            fontSize = 16.sp,
        )
        Spacer(modifier = Modifier.height(8.dp))
        BasicTextField(
            modifier = Modifier
                .padding(horizontal = 36.dp)
                .fillMaxWidth(),
            value = signupUsername,
            onValueChange = {signupUsername = it},
            textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
        )
        Spacer(modifier = Modifier.height(10.dp))
        HorizontalDivider(modifier = Modifier.padding(horizontal = 36.dp).background(color = Color.Black), thickness = 1.dp)
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 36.dp),
            text = "Email",
            color = Color.Gray,
            fontSize = 16.sp,
        )
        Spacer(modifier = Modifier.height(8.dp))
        BasicTextField(
            modifier = Modifier
                .padding(horizontal = 36.dp)
                .fillMaxWidth(),
            value = signupEmail,
            onValueChange = {signupEmail = it},
            textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
        )
        Spacer(modifier = Modifier.height(10.dp))
        HorizontalDivider(modifier = Modifier.padding(horizontal = 36.dp).background(color = Color.Black), thickness = 1.dp)
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 36.dp),
            text = "Password",
            color = Color.Gray,
            fontSize = 16.sp,
        )
        Box(
            modifier = Modifier.padding(horizontal = 36.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                BasicTextField(
                    value = signupPassword,
                    onValueChange = { signupPassword = it },
                    textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    modifier = Modifier.padding(end = 8.dp).weight(1f),
                )
                IconButton(onClick = {
                    passwordVisible = !passwordVisible
                }) {
                    val visibilityIcon = if (passwordVisible) {
                        painterResource(id = R.drawable.baseline_remove_red_eye_24)
                    } else {
                        painterResource(id = R.drawable.baseline_remove_red_eye_24)
                    }
                    Icon(
                        painter = visibilityIcon,
                        contentDescription = if (passwordVisible) "Hide password" else "Show password"
                    )
                }
            }
        }
        HorizontalDivider(modifier = Modifier.padding(horizontal = 36.dp).background(color = Color.Black), thickness = 1.dp)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 36.dp)
        ) {
            Text(
                text = "By continuing you agree to our",
                fontSize = 14.sp,
                color = Color.Black,
            )
            Text(
                modifier = Modifier.weight(1f),
                text = " Terms of Service",
                fontSize = 14.sp,
                color = colorResource(id = R.color.green1),
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 36.dp)
        ) {
            Text(
                text = "and",
                fontSize = 14.sp,
                color = Color.Black,
            )
            Text(
                modifier = Modifier.weight(1f),
                text = " Privacy Policy",
                fontSize = 14.sp,
                color = colorResource(id = R.color.green1),
                )
        }
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
                text = "Sign Up",
                fontWeight = FontWeight.Bold,
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Already have an account?",
                fontSize = 14.sp,
                color = Color.Black
            )
            Text(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .clickable {
                        navController.navigate("signingScreen")
                    },
                text = "Login",
                fontSize = 14.sp,
                color = colorResource(id = R.color.green1)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignUp() {
    SignUpScreen(navController = rememberNavController())
}
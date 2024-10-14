package com.example.groceryapp.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.groceryapp.R
import com.example.groceryapp.core.components.PrimaryButton
import com.example.groceryapp.presentation.app.RouteDestinations

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
            modifier = Modifier.fillMaxSize().padding(top = 400.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.carrot),
                contentDescription = "Background Image",
                modifier = Modifier
                    .size(40.dp)
                )
            Text(
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.surface,
                text = "Welcome \n to Our Store",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 42.dp).fillMaxWidth()
            )
            Text(
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.surface,
                    text = "Get your groceries in as fast as one hour",
                modifier = Modifier.padding(horizontal = 42.dp).padding(top = 8.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            PrimaryButton(
                text = "Login with Email",
                onClick = {navController.navigate(RouteDestinations.SIGN_IN)})
            Spacer(modifier = Modifier.height(16.dp))
            PrimaryButton(
                text = "Login with Phone Number",
                onClick = {navController.navigate(RouteDestinations.LOGIN)})
            Spacer(modifier = Modifier.height(60.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWelcome() {
    WelcomeScreen(navController = rememberNavController())
}



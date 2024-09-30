package com.example.groceryapp.presentation.App

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import com.example.groceryapp.presentation.SplashScreen.SplashScreen
import com.example.groceryapp.presentation.Account.AccountScreen
import com.example.groceryapp.presentation.Cart.CartScreen
import com.example.groceryapp.presentation.Explore.ExploreScreen
import com.example.groceryapp.presentation.Favorite.FavoriteScreen
import com.example.groceryapp.presentation.Login.LoginScreen
import com.example.groceryapp.presentation.Login.PhoneNumberScreen
import com.example.groceryapp.presentation.Login.WelcomeScreen
import com.example.groceryapp.presentation.Shop.ShopScreen

@Composable
fun Route(navController: NavHostController) {
    NavHost(navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("welcome") { WelcomeScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("shop") { ShopScreen(navController) }
        composable("explore") { ExploreScreen(navController) }
        composable("cart") { CartScreen(navController) }
        composable("favorite") { FavoriteScreen(navController) }
        composable("account") { AccountScreen(navController) }
        composable("phone number") { PhoneNumberScreen(navController) }
    }
}

package com.example.groceryapp.presentation.App

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import com.example.groceryapp.presentation.SplashScreen.SplashScreen
import com.example.groceryapp.presentation.Account.AccountScreen
import com.example.groceryapp.presentation.App.RouteDestinations.Companion.ACCOUNT
import com.example.groceryapp.presentation.App.RouteDestinations.Companion.CART
import com.example.groceryapp.presentation.App.RouteDestinations.Companion.EXPLORE
import com.example.groceryapp.presentation.App.RouteDestinations.Companion.FAVOURITE
import com.example.groceryapp.presentation.App.RouteDestinations.Companion.LOGIN
import com.example.groceryapp.presentation.App.RouteDestinations.Companion.OTP
import com.example.groceryapp.presentation.App.RouteDestinations.Companion.PHONE_NUMBER
import com.example.groceryapp.presentation.App.RouteDestinations.Companion.SELECT_LOCATION_SCREEN
import com.example.groceryapp.presentation.App.RouteDestinations.Companion.SHOP
import com.example.groceryapp.presentation.App.RouteDestinations.Companion.SIGN_IN
import com.example.groceryapp.presentation.App.RouteDestinations.Companion.SIGN_UP
import com.example.groceryapp.presentation.App.RouteDestinations.Companion.SPLASH
import com.example.groceryapp.presentation.App.RouteDestinations.Companion.WELCOME
import com.example.groceryapp.presentation.BottomNavigationBar.Explore
import com.example.groceryapp.presentation.Cart.CartScreen
import com.example.groceryapp.presentation.Explore.ExploreScreen
import com.example.groceryapp.presentation.Favorite.FavoriteScreen
import com.example.groceryapp.presentation.Login.LoginScreen
import com.example.groceryapp.presentation.Login.OTPScreen
import com.example.groceryapp.presentation.Login.PhoneNumberScreen
import com.example.groceryapp.presentation.Login.SelectLocationScreen
import com.example.groceryapp.presentation.Login.SignInScreen
import com.example.groceryapp.presentation.Login.SignUpScreen
import com.example.groceryapp.presentation.Login.WelcomeScreen
import com.example.groceryapp.presentation.Shop.ShopScreen

@Composable
fun Route(navController: NavHostController) {
    NavHost(navController, startDestination = SPLASH) {
        composable(SPLASH) { SplashScreen(navController) }
        composable(WELCOME) { WelcomeScreen(navController) }
        composable(LOGIN) { LoginScreen(navController) }
        composable(SHOP) { ShopScreen(navController) }
        composable(EXPLORE) { ExploreScreen(navController) }
        composable(CART) { CartScreen(navController) }
        composable(FAVOURITE) { FavoriteScreen(navController) }
        composable(ACCOUNT) { AccountScreen(navController) }
        composable(PHONE_NUMBER) { PhoneNumberScreen(navController) }
        composable(OTP) { OTPScreen(navController) }
        composable(SELECT_LOCATION_SCREEN) { SelectLocationScreen(navController) }
        composable(SIGN_IN) { SignInScreen(navController) }
        composable(SIGN_UP) { SignUpScreen(navController) }
    }
}

class RouteDestinations {
    companion object {
        const val SPLASH = "splash"
        const val WELCOME = "welcome"
        const val LOGIN = "login"
        const val SHOP = "shop"
        const val EXPLORE = "explore"
        const val CART = "cart"
        const val FAVOURITE = "favorite"
        const val ACCOUNT = "account"
        const val PHONE_NUMBER = "phoneNumber"
        const val OTP = "otpScreen"
        const val SELECT_LOCATION_SCREEN = "selectLocationScreen"
        const val SIGN_IN = "signingScreen"
        const val SIGN_UP = "signupScreen"
    }
}
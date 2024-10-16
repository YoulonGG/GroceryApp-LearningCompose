package com.example.groceryapp.presentation.app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import com.example.groceryapp.presentation.account.AccountScreen
import com.example.groceryapp.presentation.app.RouteDestinations.Companion.ACCEPTED_ORDER
import com.example.groceryapp.presentation.splashScreen.SplashScreen
import com.example.groceryapp.presentation.app.RouteDestinations.Companion.ACCOUNT
import com.example.groceryapp.presentation.app.RouteDestinations.Companion.CART
import com.example.groceryapp.presentation.app.RouteDestinations.Companion.EXPLORE
import com.example.groceryapp.presentation.app.RouteDestinations.Companion.EXPLORE_BAKERY
import com.example.groceryapp.presentation.app.RouteDestinations.Companion.EXPLORE_BEVERAGES
import com.example.groceryapp.presentation.app.RouteDestinations.Companion.EXPLORE_COOKING
import com.example.groceryapp.presentation.app.RouteDestinations.Companion.EXPLORE_DAIRY
import com.example.groceryapp.presentation.app.RouteDestinations.Companion.EXPLORE_FRUIT
import com.example.groceryapp.presentation.app.RouteDestinations.Companion.EXPLORE_MEAT
import com.example.groceryapp.presentation.app.RouteDestinations.Companion.FAVOURITE
import com.example.groceryapp.presentation.app.RouteDestinations.Companion.LOGIN
import com.example.groceryapp.presentation.app.RouteDestinations.Companion.OTP
import com.example.groceryapp.presentation.app.RouteDestinations.Companion.PHONE_NUMBER
import com.example.groceryapp.presentation.app.RouteDestinations.Companion.SELECT_LOCATION_SCREEN
import com.example.groceryapp.presentation.app.RouteDestinations.Companion.SHOP
import com.example.groceryapp.presentation.app.RouteDestinations.Companion.SIGN_IN
import com.example.groceryapp.presentation.app.RouteDestinations.Companion.SIGN_UP
import com.example.groceryapp.presentation.app.RouteDestinations.Companion.SPLASH
import com.example.groceryapp.presentation.app.RouteDestinations.Companion.WELCOME
import com.example.groceryapp.presentation.cart.AcceptedOrderScreen
import com.example.groceryapp.presentation.cart.CartScreen
import com.example.groceryapp.presentation.explore.exploreItems.BakeryAndSnackScreen
import com.example.groceryapp.presentation.explore.exploreItems.DairyAndEggScreen
import com.example.groceryapp.presentation.explore.ExploreScreen
import com.example.groceryapp.presentation.explore.exploreItems.MeatAndFishScreen
import com.example.groceryapp.presentation.explore.exploreItems.BeveragesScreen
import com.example.groceryapp.presentation.explore.exploreItems.CookingOilAndGheeScreen
import com.example.groceryapp.presentation.explore.exploreItems.FruitAndVegetableScreen
import com.example.groceryapp.presentation.favorite.FavoriteScreen
import com.example.groceryapp.presentation.login.LoginScreen
import com.example.groceryapp.presentation.login.OTPScreen
import com.example.groceryapp.presentation.login.PhoneNumberScreen
import com.example.groceryapp.presentation.login.SelectLocationScreen
import com.example.groceryapp.presentation.login.SignInScreen
import com.example.groceryapp.presentation.login.SignUpScreen
import com.example.groceryapp.presentation.login.WelcomeScreen
import com.example.groceryapp.presentation.shop.ShopScreen

@Composable
fun Route(navController: NavHostController) {
    NavHost(navController, startDestination = SHOP) {
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
        composable(EXPLORE_BEVERAGES) { BeveragesScreen(navController) }
        composable(ACCEPTED_ORDER) { AcceptedOrderScreen(navController) }
        composable(EXPLORE_MEAT) { MeatAndFishScreen(navController) }
        composable(EXPLORE_FRUIT) { FruitAndVegetableScreen(navController) }
        composable(EXPLORE_DAIRY) { DairyAndEggScreen(navController) }
        composable(EXPLORE_COOKING) { CookingOilAndGheeScreen(navController) }
        composable(EXPLORE_BAKERY) { BakeryAndSnackScreen(navController) }
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
        const val EXPLORE_BEVERAGES = "exploreBeverages"
        const val ACCEPTED_ORDER = "acceptedOrder"
        const val EXPLORE_MEAT = "exploreMeat"
        const val EXPLORE_FRUIT = "exploreFruit"
        const val EXPLORE_DAIRY = "exploreDairy"
        const val EXPLORE_COOKING = "exploreCooking"
        const val EXPLORE_BAKERY = "exploreBakery"
    }
}
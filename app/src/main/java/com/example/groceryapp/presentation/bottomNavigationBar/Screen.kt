package com.example.groceryapp.presentation.bottomNavigationBar

import androidx.annotation.DrawableRes
import com.example.groceryapp.R

sealed class BottomNavItem(
    val route: String,
    @DrawableRes val icon: Int,
    val label: String)

data object Shop : BottomNavItem("shop", icon = R.drawable.shop, "Shop")
data object Explore : BottomNavItem("explore", icon = R.drawable.explore, "Explore")
data object Cart : BottomNavItem("cart", icon = R.drawable.cart, "Cart")
data object Favorite : BottomNavItem("favorite", icon = R.drawable.favorite, "Favorite")
data object Account : BottomNavItem("account", icon = R.drawable.person, "Account")
package com.example.groceryapp.presentation.bottomNavigationBar

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.groceryapp.R

@Composable
fun BottomNavigation(
    navController: NavController,
    state: Boolean = true,
) {
    val green = colorResource(id = R.color.green1)
    if (state) {

        val screens = remember {
            listOf(Shop, Explore, Cart, Favorite, Account)
        }

        NavigationBar(
            tonalElevation = 8.dp,
            containerColor = Color.White,
            modifier = Modifier
                .shadow(elevation = 8.dp)
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            screens.forEach { screen ->
                NavigationBarItem(
                    label = { Text(text = screen.label) },
                    icon = {
                        Icon(
                            painter = painterResource(id = screen.icon),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    },
                    selected = currentRoute == screen.route,
                    onClick = {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }

                    },
                    colors = NavigationBarItemDefaults.colors(
                        unselectedTextColor = Color.Gray,
                        selectedTextColor = green,
                        selectedIconColor = green,
                        unselectedIconColor = Color.Gray,
                        indicatorColor = Color.White
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNavigation() {
    BottomNavigation(navController = rememberNavController())
}


package com.debanshu777.compose_github.ui.base.components

import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.debanshu777.compose_github.ui.base.Screen

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        Screen.TrendingScreen,
        Screen.FollowScreen
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomAppBar {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

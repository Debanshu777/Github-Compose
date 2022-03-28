package com.debanshu777.compose_github.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.debanshu777.compose_github.network.dataSource.GitHubViewModel
import com.debanshu777.compose_github.ui.feature_profile.ProfileScreen
import com.debanshu777.compose_github.ui.feature_search.SearchScreen

@Composable
fun Navigation(viewModel: GitHubViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SearchScreen.route) {
        composable(route = Screen.SearchScreen.route){
            SearchScreen(viewModel,navController)
        }
        composable(route = Screen.ProfileScreen.route){
            ProfileScreen(viewModel)
        }
    }
}
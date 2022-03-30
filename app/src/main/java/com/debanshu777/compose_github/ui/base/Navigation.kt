package com.debanshu777.compose_github.ui.base

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.debanshu777.compose_github.network.dataSource.githubViewModel
import com.debanshu777.compose_github.ui.feature_follow.FollowScreen
import com.debanshu777.compose_github.ui.feature_profile.ProfileScreen
import com.debanshu777.compose_github.ui.feature_search.SearchScreen
import com.debanshu777.compose_github.ui.feature_trending.TrendingScreen

@Composable
fun Navigation(viewModel: githubViewModel, navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.TrendingScreen.route) {
        composable(route = Screen.SearchScreen.route){
            SearchScreen(viewModel,navController)
        }
        composable(route = Screen.ProfileScreen.route){
            ProfileScreen(viewModel)
        }
        composable(route= Screen.TrendingScreen.route){
            TrendingScreen()
        }
        composable(route = Screen.FollowScreen.route){
            FollowScreen()
        }
    }
}
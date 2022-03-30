package com.debanshu777.compose_github.ui.base

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route:String, val title:String, val icon:ImageVector){
    object SearchScreen: Screen("search_screen","Search", Icons.Default.Search)
    object ProfileScreen: Screen("profile_screen","Profile", Icons.Default.Person)
    object TrendingScreen: Screen("trending_screen","Trending", Icons.Default.DateRange)
    object FollowScreen: Screen("follow_screen","Follow", Icons.Default.Favorite)
}

package com.debanshu777.compose_github.ui.navigation

sealed class Screen(val route:String){
    object SearchScreen: Screen("search_screen")
    object ProfileScreen: Screen("profile_screen")
}

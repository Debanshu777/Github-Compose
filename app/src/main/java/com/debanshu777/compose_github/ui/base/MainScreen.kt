package com.debanshu777.compose_github.ui.base

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import com.debanshu777.compose_github.network.dataSource.githubViewModel
import com.debanshu777.compose_github.ui.base.components.BottomBar
import com.debanshu777.compose_github.ui.feature_search.components.MainAppBar
import com.debanshu777.compose_github.ui.feature_search.state.SearchState
import com.debanshu777.compose_github.ui.feature_search.state.SearchWidgetState

@Composable
fun MainScreen(viewModel: githubViewModel){
    val navController = rememberNavController()
    val searchWidgetState by viewModel.searchWidgetState
    val searchTextState by viewModel.searchTextState
    Scaffold(
        topBar = {
            MainAppBar(
                searchWidgetState = searchWidgetState,
                searchTextState = searchTextState,
                onTextChange = {
                    viewModel.updateSearchTextState(it)
                },
                onCloseClicked = {
                    viewModel.updateSearchTextState("")
                    viewModel.updateSearchWidgetState(SearchWidgetState.CLOSED)
                    viewModel.searchState.value= SearchState(data= emptyList())
                    navController.navigate(Screen.TrendingScreen.route)
                },
                onSearchClick = {
                    viewModel.searchUser(it)
                },
                onSearchTriggered={
                    navController.navigate(Screen.SearchScreen.route)
                    viewModel.updateSearchWidgetState(SearchWidgetState.OPENED)
                }
            )
        },
        bottomBar = { BottomBar(navController = navController)}
    ) {
        Navigation(viewModel,navController)
    }
}
package com.debanshu777.compose_github.ui.base

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.debanshu777.compose_github.network.dataSource.GitHubViewModel
import com.debanshu777.compose_github.ui.base.components.BottomBar
import com.debanshu777.compose_github.ui.base.components.MainAppBar
import com.debanshu777.compose_github.ui.base.state.SearchState
import com.debanshu777.compose_github.ui.base.state.SearchWidgetState
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: GitHubViewModel) {
    val navController = rememberNavController()
    val searchWidgetState by viewModel.searchWidgetState
    val searchTextState by viewModel.searchTextState
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val onShowSnackbar: (String) -> Unit = { task ->
        coroutineScope.launch {
            snackbarHostState.showSnackbar(
                message = task
            )
        }
    }
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
                    viewModel.searchState.value = SearchState(data = emptyList())
                    navController.navigate(Screen.TrendingScreen.route)
                },
                onSearchClick = {
                    viewModel.searchUser(it)
                },
                onSearchTriggered = {
                    navController.navigate(Screen.SearchScreen.route)
                    viewModel.updateSearchWidgetState(SearchWidgetState.OPENED)
                },
                onDurationTypeClick = {
                    viewModel.updateDurationTypeFilterVisibility()
                }
            )
        },
        bottomBar = { BottomBar(navController = navController) },
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) {
        Navigation(viewModel, navController, onShowSnackbar)
    }
}

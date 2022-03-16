package com.debanshu777.compose_github.ui.feature_search

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.debanshu777.compose_github.network.dataSource.GitHubViewModel
import com.debanshu777.compose_github.ui.feature_search.components.MainAppBar
import com.debanshu777.compose_github.ui.feature_search.components.SearchBar
import com.debanshu777.compose_github.ui.feature_search.state.SearchWidgetState

@Composable
fun SearchScreen(viewModel: GitHubViewModel){
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
                },
                onSearchClick = {
                                Log.e("Search Clicked",it)
                },
                onSearchTriggered={
                    viewModel.updateSearchWidgetState(SearchWidgetState.OPENED)
                }
            )
        }
    ) {
        
    }
}
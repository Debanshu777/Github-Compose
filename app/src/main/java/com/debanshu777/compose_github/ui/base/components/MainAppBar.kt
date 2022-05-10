package com.debanshu777.compose_github.ui.feature_search.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.debanshu777.compose_github.ui.base.components.SearchBar
import com.debanshu777.compose_github.ui.feature_search.state.SearchWidgetState

@Composable
fun MainAppBar(
    searchWidgetState: SearchWidgetState,
    searchTextState: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClick: (String) -> Unit,
    onSearchTriggered: () -> Unit
) {
    when (searchWidgetState) {
        SearchWidgetState.CLOSED -> {
            DefaultAppBar(
                onSearchClick = onSearchTriggered
            )
        }
        SearchWidgetState.OPENED -> {
            SearchBar(
                text = searchTextState,
                onTextChange = onTextChange,
                onCloseClicked = onCloseClicked,
                onSearchClicked = onSearchClick
            )
        }
    }
}

@Composable
fun DefaultAppBar(onSearchClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = "GitHub")
        },
        actions = {
            IconButton(onClick = { onSearchClick() }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search Icon"
                )
            }
        },
        elevation=0.dp
    )
}

@Composable
@Preview
fun SearchScreenPreview() {
    DefaultAppBar(onSearchClick = {})
}

package com.debanshu777.compose_github.ui.base.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.debanshu777.compose_github.ui.base.state.SearchWidgetState

@Composable
fun MainAppBar(
    searchWidgetState: SearchWidgetState,
    searchTextState: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClick: (String) -> Unit,
    onSearchTriggered: () -> Unit,
    onDurationTypeClick: () -> Unit
) {
    when (searchWidgetState) {
        SearchWidgetState.CLOSED -> {
            DefaultAppBar(
                onSearchClick = onSearchTriggered,
                onDurationTypeClick = onDurationTypeClick,
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
fun DefaultAppBar(onSearchClick: () -> Unit, onDurationTypeClick: () -> Unit) {
    SmallTopAppBar(
        title = {
            Text(text = "GitHub")
        },
        actions = {
            IconButton(onClick = { onDurationTypeClick() }) {
                Icon(
                    imageVector = Icons.Filled.FilterList,
                    contentDescription = "Search Icon"
                )
            }
            IconButton(onClick = { onSearchClick() }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search Icon"
                )
            }
        },
    )
}

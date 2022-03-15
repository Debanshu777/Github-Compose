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
import com.debanshu777.compose_github.ui.feature_search.state.SearchWidgetState

@Composable
@Preview
fun SearchScreenPreview(){
    DefaultAppBar(onSearchClick={})
}

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

@Composable
fun MainAppBar(
    searchWidgetState: SearchWidgetState,
    searchTextState: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClick: (String) -> Unit,
    onSearchTriggered:()->Unit
){
    when(searchWidgetState){
        SearchWidgetState.CLOSED->{
            DefaultAppBar(
                onSearchClick=onSearchTriggered
            )
        }
        SearchWidgetState.OPENED->{
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
fun DefaultAppBar(onSearchClick:()->Unit){
    TopAppBar(
        title = {
            Text(text = "GitHub")
        },
        actions = {
            IconButton(onClick = {onSearchClick()}) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search Icon"
                )
            }
        }
    )
}

@Composable
fun SearchBar(
    text: String,
    onTextChange:(String)->Unit,
    onCloseClicked:()->Unit,
    onSearchClicked:(String)->Unit
){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        elevation = AppBarDefaults.TopAppBarElevation
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = {
                onTextChange(it)
            },
            placeholder = {
                Text(
                    modifier = Modifier.alpha(ContentAlpha.medium),
                    text = "Search here...",
                    color = Color.White
                )
            },
            textStyle = TextStyle(
                fontSize = 14.sp
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium),
                    onClick = {  }
                ){
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription ="Search Icons",
                        tint = Color.White
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        if(text.isNotEmpty()){
                            onTextChange("")
                        }else{
                            onCloseClicked()
                        }
                    }
                ){
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription ="Close Icons",
                        tint = Color.White
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                cursorColor = Color.White.copy(alpha = ContentAlpha.medium)
            )

        )
    }
}

@Composable
@Preview
fun SearchBarPreview(){
    SearchBar(text = "Some Random Text", onTextChange = {}, onCloseClicked = { }, onSearchClicked ={} )
}
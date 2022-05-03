package com.debanshu777.compose_github.ui.feature_search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.debanshu777.compose_github.network.dataSource.GitHubViewModel
import com.debanshu777.compose_github.ui.base.Screen
import com.debanshu777.compose_github.ui.feature_search.components.Card

@OptIn(ExperimentalUnitApi::class)
@Composable
fun SearchScreen(viewModel: GitHubViewModel, navController: NavController) {
    val searchData by viewModel.searchState.collectAsState()
    Scaffold() {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(10.dp)
        ) {
            items(searchData.data) { item ->
                Card(
                    modifier = Modifier.height(120.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(vertical = 20.dp, horizontal = 5.dp)
                            .clickable {
                                item.login?.let { it1 -> viewModel.getUserData(it1) }
                                navController.navigate(Screen.ProfileScreen.route)
                            },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Greeting(item.toString())
                        BadgedBox(
                            modifier = Modifier.padding(start = 10.dp),
                            badge = {
                                if (item.type != "User") {
                                    Badge(
                                        modifier = Modifier
                                            .height(10.dp)
                                            .width(10.dp),
                                        backgroundColor = Color.Blue
                                    )
                                }
                            }
                        ) {
                            AsyncImage(
                                modifier = Modifier
                                    .height(70.dp)
                                    .width(70.dp)
                                    .clip(CircleShape),
                                model = item.avatarUrl,
                                contentScale = ContentScale.Fit,
                                contentDescription = "User Avatar"
                            )
                        }
                        Text(
                            modifier = Modifier.padding(20.dp),
                            text = "@${item.login}",
                            fontSize = TextUnit(value = 20F, type = TextUnitType.Sp),
                        )
                    }
                }
            }
        }
    }
}

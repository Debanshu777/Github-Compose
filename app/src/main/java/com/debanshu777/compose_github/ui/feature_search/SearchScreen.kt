package com.debanshu777.compose_github.ui.feature_search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.debanshu777.compose_github.R
import com.debanshu777.compose_github.network.dataSource.GitHubViewModel
import com.debanshu777.compose_github.ui.base.Screen
import com.debanshu777.compose_github.utils.Loader

@OptIn(ExperimentalUnitApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(viewModel: GitHubViewModel, navController: NavController) {
    val searchData by viewModel.searchState.collectAsState()
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 56.dp),
            contentPadding = PaddingValues(10.dp)
        ) {
            if (searchData.isLoading) {
                item{
                    Box(modifier=Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Loader(R.raw.github_loading_anim)
                    }
                }
            } else {
                items(searchData.data) { item ->
                    ElevatedCard(
                        modifier = Modifier
                            .height(120.dp)
                            .padding(vertical = 5.dp)
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
                            BadgedBox(
                                modifier = Modifier.padding(start = 10.dp),
                                badge = {
                                    if (item.type != "User") {
                                        Badge(
                                            modifier = Modifier
                                                .height(10.dp)
                                                .width(10.dp),
                                            containerColor = Color.Cyan
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
                                text = "@${item.login ?: "NA"}",
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                fontWeight = FontWeight.Bold,
                                fontSize = TextUnit(value = 18F, type = TextUnitType.Sp),
                            )
                        }
                    }
                }
            }

    }
}

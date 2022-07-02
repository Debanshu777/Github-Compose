package com.debanshu777.compose_github.ui.base.components.tabHandler

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.debanshu777.compose_github.R
import com.debanshu777.compose_github.network.model.TrendingDeveloperItem
import com.debanshu777.compose_github.network.model.TrendingRepositoryItem
import com.debanshu777.compose_github.ui.feature_follow.components.FollowDeveloperCard
import com.debanshu777.compose_github.ui.feature_follow.components.FollowRepositoryCard
import com.debanshu777.compose_github.ui.feature_trending.components.DeveloperCard
import com.debanshu777.compose_github.ui.feature_trending.components.RepositoryCard
import com.debanshu777.compose_github.utils.Loader
import composedb.githubDB.DeveloperFollow
import composedb.githubDB.RepositoryFollow
import kotlinx.coroutines.Job

@OptIn(ExperimentalUnitApi::class)
@Composable
fun TabLayout(
    data: List<Any>,
    actionList: List<(String) -> Job>,
    cardAction: List<(Long) -> Job>,
    navController: NavController,
    onShowSnackbar: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        if (data.isEmpty()) {
            Box(modifier=Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(
                   horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Loader(R.raw.empty_page, Modifier.height(250.dp))
                    Text(
                        modifier = Modifier.padding(vertical = 10.dp),
                        text = "No Items Here",
                        fontWeight = FontWeight.W300,
                        fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp),
                contentPadding = PaddingValues(10.dp)
            ) {
                items(data) { item ->
                    if (item is TrendingRepositoryItem) {
                        RepositoryCard(item, onShowSnackbar)
                    }
                    if (item is DeveloperFollow) {
                        FollowDeveloperCard(
                            item,
                            navController,
                            actionList[1],
                            cardAction[1],
                            onShowSnackbar
                        )
                    }
                    if (item is RepositoryFollow) {
                        FollowRepositoryCard(item, cardAction[0], onShowSnackbar)
                    }
                    if (item is TrendingDeveloperItem) {
                        DeveloperCard(item, navController, actionList[1], onShowSnackbar)
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
        }
    }
}

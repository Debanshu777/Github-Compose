package com.debanshu777.compose_github.ui.base.components.tabHandler

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.debanshu777.compose_github.network.model.TrendingDeveloperItem
import com.debanshu777.compose_github.network.model.TrendingRepositoryItem
import com.debanshu777.compose_github.ui.feature_follow.components.FollowDeveloperCard
import com.debanshu777.compose_github.ui.feature_follow.components.FollowRepositoryCard
import com.debanshu777.compose_github.ui.feature_trending.components.DeveloperCard
import com.debanshu777.compose_github.ui.feature_trending.components.RepositoryCard
import composedb.githubDB.DeveloperFollow
import composedb.githubDB.RepositoryFollow

@Composable
fun <T> TabLayout(data: List<T>, navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp),
            contentPadding = PaddingValues(10.dp)
        ) {
            items(data) { item ->
                if (item is TrendingRepositoryItem) {
                    RepositoryCard(item)
                }
                if(item is DeveloperFollow){
                    FollowDeveloperCard(item)
                }
                if(item is RepositoryFollow){
                    FollowRepositoryCard(item)
                }
                if (item is TrendingDeveloperItem) {
                    DeveloperCard(item,navController)
                }
                Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }
}

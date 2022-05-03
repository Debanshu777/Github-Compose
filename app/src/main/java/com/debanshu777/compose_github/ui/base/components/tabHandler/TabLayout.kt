package com.debanshu777.compose_github.ui.base.components.tabHandler

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import com.debanshu777.compose_github.network.model.TrendingDeveloperItem
import com.debanshu777.compose_github.network.model.TrendingRepositoryItem
import com.debanshu777.compose_github.ui.feature_trending.components.DeveloperCard
import com.debanshu777.compose_github.ui.feature_trending.components.RepositoryCard

@OptIn(ExperimentalUnitApi::class)
@Composable
fun <T> TabLayout(data: List<T>) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(10.dp)
        ) {
            items(data) { item ->
                if (item is TrendingRepositoryItem) {
                    RepositoryCard(item)
                }
                if (item is TrendingDeveloperItem) {
                    DeveloperCard(item)
                }
                Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }
}

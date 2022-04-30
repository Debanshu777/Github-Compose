package com.debanshu777.compose_github.ui.feature_trending.state

import com.debanshu777.compose_github.network.model.TrendingDeveloperItem
import com.debanshu777.compose_github.network.model.TrendingRepositoryItem

data class DeveloperTrendingState(
    val isLoading:Boolean=false,
    val data: List<TrendingDeveloperItem> = emptyList(),
    val error: String?=""
)

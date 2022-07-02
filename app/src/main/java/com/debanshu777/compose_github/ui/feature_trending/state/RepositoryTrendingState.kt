package com.debanshu777.compose_github.ui.feature_trending.state

import com.debanshu777.compose_github.network.model.TrendingRepositoryItem

data class RepositoryTrendingState(
    val isLoading: Boolean = false,
    val data: List<TrendingRepositoryItem> = emptyList(),
    val error: String? = null
)

package com.debanshu777.compose_github.ui.feature_trending

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.debanshu777.compose_github.network.dataSource.GitHubViewModel
import com.debanshu777.compose_github.ui.base.components.tabHandler.TabHandler
import com.google.accompanist.pager.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TrendingScreen(viewModel: GitHubViewModel) {
    val trendingRepositoryDataState by viewModel.trendingRepositoryDataState.collectAsState()
    val trendingDeveloperDataState by viewModel.trendingDeveloperDataState.collectAsState()

    val pagerState = rememberPagerState(0)
    val pageCount = 2
    val tabList = listOf("Repository", "Developer")
    val dataList = listOf(trendingRepositoryDataState.data, trendingDeveloperDataState.data)
    TabHandler(pagerState, pageCount, tabList, dataList)
}

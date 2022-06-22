package com.debanshu777.compose_github.ui.feature_trending

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.debanshu777.compose_github.network.dataSource.GitHubViewModel
import com.debanshu777.compose_github.ui.base.components.DropDownMenu
import com.debanshu777.compose_github.ui.base.components.tabHandler.TabHandler
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TrendingScreen(viewModel: GitHubViewModel, navController: NavController) {
    val trendingRepositoryDataState by viewModel.trendingRepositoryDataState.collectAsState()
    val trendingDeveloperDataState by viewModel.trendingDeveloperDataState.collectAsState()
    val durationTypeFilterVisibility by viewModel.durationTypeFilterVisibility.observeAsState()
    val durationType by viewModel.durationType.observeAsState()
    val pagerState = rememberPagerState(0)
    val pageCount = 2
    val tabList = listOf("Repositories", "Developers")
    val dataList = listOf(trendingRepositoryDataState.data, trendingDeveloperDataState.data)
    Column(modifier = Modifier.padding(top = if (durationTypeFilterVisibility == true) 56.dp else 15.dp)) {
        DropDownMenu(
            durationType,
            durationTypeFilterVisibility ?: false
        ) { viewModel.updateDurationType(it) }
        TabHandler(pagerState, pageCount, tabList, dataList, navController)
    }
}
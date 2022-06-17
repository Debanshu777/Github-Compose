package com.debanshu777.compose_github.ui.feature_follow

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.debanshu777.compose_github.network.dataSource.GitHubViewModel
import com.debanshu777.compose_github.ui.base.components.tabHandler.TabHandler
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FollowScreen(navController: NavController, viewModel: GitHubViewModel = hiltViewModel()) {
    val developerFollowList by viewModel.developerList.collectAsState(emptyList())
    val repositoryFollowList by viewModel.repositoryList.collectAsState(emptyList())
    val pagerState = rememberPagerState(0)
    val pageCount = 2
    val tabList = listOf("Repository", "Developer")
    val dataList = listOf(repositoryFollowList, developerFollowList)
    TabHandler(pagerState, pageCount, tabList, dataList, navController)
}

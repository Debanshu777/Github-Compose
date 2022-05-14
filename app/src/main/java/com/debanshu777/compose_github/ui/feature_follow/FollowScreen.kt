package com.debanshu777.compose_github.ui.feature_follow

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.debanshu777.compose_github.network.dataSource.GitHubViewModel
import com.debanshu777.compose_github.ui.base.components.tabHandler.TabHandler
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import composedb.githubDB.DeveloperFollow

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FollowScreen(navController: NavController,viewModel:GitHubViewModel= hiltViewModel()) {
    // val trendingDeveloperDataState by viewModel.trendingDeveloperDataState.collectAsState()
    val developerFollowList by viewModel.developerList.collectAsState(emptyList())
    val repositoryFollowList by viewModel.repositoryList.collectAsState(emptyList())
    val pagerState = rememberPagerState(0)
    val pageCount = 2
    val tabList = listOf("Repository", "Developer")
    val dataList = listOf(repositoryFollowList,developerFollowList)
    TabHandler(pagerState, pageCount, tabList, dataList,navController)
}

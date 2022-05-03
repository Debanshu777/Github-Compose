package com.debanshu777.compose_github.ui.feature_follow

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FollowScreen() {
    // val trendingDeveloperDataState by viewModel.trendingDeveloperDataState.collectAsState()

    val pagerState = rememberPagerState(0)
    val pageCount = 2
    val tabList = listOf("Repository", "Developer")
    // val dataList= listOf(trendingDeveloperDataState.data,trendingDeveloperDataState.data)

    // TabHandler(pagerState,pageCount,tabList,dataList)
}

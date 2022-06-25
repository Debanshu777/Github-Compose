package com.debanshu777.compose_github.ui.base.components.tabHandler

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.Job

@ExperimentalPagerApi
@Composable
fun TabHandler(
    pagerState: PagerState,
    pageCount: Int,
    tabNames: List<String>,
    actionList: List<(String) -> Job>,
    cardAction: List<(Long) -> Job>,
    dataList: List<List<Any>>,
    navController: NavController
) {
    Column {
        Tabs(pagerState = pagerState, tabNames)
        TabsContent(pagerState = pagerState, pageCount, actionList, cardAction ,dataList, navController)
    }
}

@ExperimentalPagerApi
@Composable
fun TabsContent(
    pagerState: PagerState,
    pageCount: Int,
    actionList: List<(String) -> Job>,
    cardAction: List<(Long) -> Job>,
    dataList: List<List<Any>>,
    navController: NavController
) {
    HorizontalPager(state = pagerState, count = pageCount) { page ->
        when (page) {
            0 -> TabLayout(dataList[0], actionList, cardAction,navController)
            1 -> TabLayout(dataList[1], actionList, cardAction,navController)
        }
    }
}

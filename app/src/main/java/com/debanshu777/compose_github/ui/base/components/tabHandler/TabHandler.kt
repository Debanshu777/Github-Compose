package com.debanshu777.compose_github.ui.base.components.tabHandler

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@ExperimentalPagerApi
@Composable
fun TabHandler(pagerState: PagerState, pageCount: Int, tabNames: List<String>, dataList: List<List<Any>>, navController: NavController) {
    Column(
        modifier = Modifier.padding(top = 56.dp)
    ) {
        Tabs(pagerState = pagerState, tabNames)
        TabsContent(pagerState = pagerState, pageCount, dataList, navController)
    }
}

@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState, pageCount: Int, dataList: List<List<Any>>, navController: NavController) {
    HorizontalPager(state = pagerState, count = pageCount) { page ->
        when (page) {
            0 -> TabLayout(dataList[0],navController)
            1 -> TabLayout(dataList[1],navController)
        }
    }
}

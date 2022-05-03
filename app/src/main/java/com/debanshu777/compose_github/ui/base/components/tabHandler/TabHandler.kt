package com.debanshu777.compose_github.ui.base.components.tabHandler

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@ExperimentalPagerApi
@Composable
fun TabHandler(pagerState: PagerState, pageCount: Int, tabNames: List<String>, dataList: List<List<Any>>) {
    Column() {
        Tabs(pagerState = pagerState, tabNames)
        TabsContent(pagerState = pagerState, pageCount, dataList)
    }
}

@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState, pageCount: Int, dataList: List<List<Any>>) {
    HorizontalPager(state = pagerState, count = pageCount) { page ->
        when (page) {
            0 -> TabLayout(dataList[0])
            1 -> TabLayout(dataList[1])
        }
    }
}

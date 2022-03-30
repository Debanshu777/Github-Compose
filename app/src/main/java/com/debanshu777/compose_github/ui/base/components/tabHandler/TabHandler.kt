package com.debanshu777.compose_github.ui.base.components.tabHandler

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@ExperimentalPagerApi
@Composable
fun TabHandler(pagerState: PagerState,pageCount:Int,tabNames:List<String>) {
    Column(
    ) {
        Tabs(pagerState = pagerState,tabNames)
        TabsContent(pagerState = pagerState,pageCount)
    }
}

@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState,pageCount:Int) {
    HorizontalPager(state = pagerState,count=pageCount) { page ->
        when(page) {
            0 -> TabLayout(data = "Make It Easy One")
            1 -> TabLayout(data = "Make It Easy Two")
        }
    }
}

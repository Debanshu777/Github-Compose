package com.debanshu777.compose_github.ui.feature_follow

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.debanshu777.compose_github.ui.base.components.tabHandler.TabHandler
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FollowScreen(){
   val pagerState = rememberPagerState(0)
   val pageCount=2
   val tabList = listOf("Repository", "Developer")
   TabHandler(pagerState,pageCount,tabList)
}
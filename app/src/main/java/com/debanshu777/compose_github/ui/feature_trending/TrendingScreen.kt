package com.debanshu777.compose_github.ui.feature_trending

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.debanshu777.compose_github.ui.base.components.tabHandler.TabHandler
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TrendingScreen() {
    val pagerState = rememberPagerState(0)
    val pageCount=2
    val tabList = listOf("Repository", "Developer")
    TabHandler(pagerState,pageCount,tabList)
}
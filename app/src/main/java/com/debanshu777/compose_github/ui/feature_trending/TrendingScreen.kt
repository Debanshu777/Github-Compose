package com.debanshu777.compose_github.ui.feature_trending

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.debanshu777.compose_github.R
import com.debanshu777.compose_github.network.dataSource.GitHubViewModel
import com.debanshu777.compose_github.ui.base.components.DropDownMenu
import com.debanshu777.compose_github.ui.base.components.tabHandler.TabHandler
import com.debanshu777.compose_github.utils.Loader
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class, ExperimentalUnitApi::class)
@Composable
fun TrendingScreen(
    viewModel: GitHubViewModel,
    navController: NavController,
    onShowSnackbar: (String) -> Unit
) {
    val trendingRepositoryDataState by viewModel.trendingRepositoryDataState.collectAsState()
    val trendingDeveloperDataState by viewModel.trendingDeveloperDataState.collectAsState()
    val durationTypeFilterVisibility by viewModel.durationTypeFilterVisibility.observeAsState()
    val durationType by viewModel.durationType.observeAsState()
    val pagerState = rememberPagerState(0)
    val pageCount = 2
    val tabList = listOf("Repositories", "Developers")
    val actionList =
        listOf({ s: String -> viewModel.getUserData(s) }, { s: String -> viewModel.getUserData(s) })
    val dataList = listOf(trendingRepositoryDataState.data, trendingDeveloperDataState.data)
    Column(modifier = Modifier.padding(top = if (durationTypeFilterVisibility == true) 56.dp else 15.dp)) {
        DropDownMenu(
            durationType,
            durationTypeFilterVisibility ?: false
        ) { viewModel.updateDurationType(it) }
        if (trendingDeveloperDataState.isLoading && trendingRepositoryDataState.isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Loader(R.raw.github_loading_anim)
            }
        } else if ((!trendingDeveloperDataState.isLoading && !trendingRepositoryDataState.isLoading) && (trendingDeveloperDataState.error != null || trendingRepositoryDataState.error != null)) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Loader(R.raw.error_page, Modifier.height(250.dp))
                    Text(
                        modifier = Modifier.padding(vertical = 10.dp),
                        text = "Some Issue From Our Side",
                        fontWeight = FontWeight.W300,
                        fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
                    )
                }
            }
        } else {
            TabHandler(
                pagerState,
                pageCount,
                tabList,
                actionList,
                listOf(),
                dataList,
                navController,
                onShowSnackbar
            )
        }
    }
}
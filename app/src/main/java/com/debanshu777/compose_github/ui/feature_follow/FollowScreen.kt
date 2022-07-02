package com.debanshu777.compose_github.ui.feature_follow

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.debanshu777.compose_github.network.dataSource.GitHubViewModel
import com.debanshu777.compose_github.ui.base.components.tabHandler.TabHandler
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FollowScreen(
    navController: NavController,
    onShowSnackbar: (String) -> Unit,
    viewModel: GitHubViewModel = getViewModel()
) {
    val developerFollowList by viewModel.developerList.collectAsState(emptyList())
    val repositoryFollowList by viewModel.repositoryList.collectAsState(emptyList())
    val pagerState = rememberPagerState(0)
    val pageCount = 2
    val tabList = listOf("Repositories", "Developers")
    val dataList = listOf(repositoryFollowList, developerFollowList)
    val actionList =
        listOf({ s: String -> viewModel.getUserData(s) }, { s: String -> viewModel.getUserData(s) })
    val cardAction = listOf({ i: Long -> viewModel.deleteRepositoryById(i) },
        { i: Long -> viewModel.deleteDeveloperById(i) })
    Column(modifier = Modifier.padding(top = 56.dp)) {
        TabHandler(
            pagerState,
            pageCount,
            tabList,
            actionList,
            cardAction,
            dataList,
            navController,
            onShowSnackbar
        )
    }
}

package com.debanshu777.compose_github.ui.feature_profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.debanshu777.compose_github.network.dataSource.GitHubViewModel
import com.debanshu777.compose_github.ui.feature_profile.components.ProfileDetailsScreen
import com.debanshu777.compose_github.ui.feature_profile.components.UserPinnedProjectSection
import com.debanshu777.compose_github.ui.feature_profile.components.UserStatsSection

@Composable
fun ProfileScreen(viewModel: GitHubViewModel = hiltViewModel()) {
    val profileData by viewModel.userDataState.observeAsState()
    val userPinnedProject by viewModel.userPinnedState.observeAsState()
    val userStats by viewModel.userStatsState.observeAsState()
    Column(
        modifier = Modifier
            .padding(top = 56.dp)
            .verticalScroll(rememberScrollState())
    ) {
        ProfileDetailsScreen(profileData)
        UserStatsSection(userStats)
        UserPinnedProjectSection(userPinnedProject)
    }
}

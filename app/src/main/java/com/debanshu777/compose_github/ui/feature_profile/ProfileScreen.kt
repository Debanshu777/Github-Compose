package com.debanshu777.compose_github.ui.feature_profile

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.debanshu777.compose_github.network.dataSource.GitHubViewModel

@Composable
fun ProfileScreen(viewModel: GitHubViewModel) {
    val profileData by viewModel.userDataState.collectAsState()
    Text(text = profileData.data.toString())
}

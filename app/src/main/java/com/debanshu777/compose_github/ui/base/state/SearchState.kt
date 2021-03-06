package com.debanshu777.compose_github.ui.base.state

import com.debanshu777.compose_github.network.model.GitHubSearchUserList

data class SearchState(
    val isLoading: Boolean = false,
    val data: List<GitHubSearchUserList> = emptyList(),
    val error: String? = null
)

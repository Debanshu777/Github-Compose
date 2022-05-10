package com.debanshu777.compose_github.ui.feature_follow.state

import composedb.githubDB.DeveloperFollow

data class DeveloperFollowState (
    val isLoading: Boolean = false,
    val data: List<DeveloperFollow> = emptyList(),
    val error: String? = ""
)
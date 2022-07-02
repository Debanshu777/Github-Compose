package com.debanshu777.compose_github.ui.feature_profile.state

import com.debanshu777.compose_github.network.model.userStats.UserStats

data class ProfileStatsState(
    val isLoading: Boolean = false,
    val data: UserStats? = null,
    val error: String? = null
)

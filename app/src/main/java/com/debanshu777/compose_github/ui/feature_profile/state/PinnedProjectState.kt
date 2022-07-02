package com.debanshu777.compose_github.ui.feature_profile.state

import com.debanshu777.compose_github.network.model.PinnedUserProjectItem

data class PinnedProjectState(
    val isLoading: Boolean = false,
    val data: List<PinnedUserProjectItem>? = null,
    val error: String? = null
)

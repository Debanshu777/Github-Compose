package com.debanshu777.compose_github.ui.feature_profile.state

import com.debanshu777.compose_github.network.model.GitHubUserResponse

data class ProfileState(
    val isLoading: Boolean = false,
    val data: GitHubUserResponse? = null,
    val error: String? = null
){
    override fun equals(other: Any?): Boolean {
        return false
    }

    override fun hashCode(): Int {
        return data?.hashCode() ?: 0
    }
}

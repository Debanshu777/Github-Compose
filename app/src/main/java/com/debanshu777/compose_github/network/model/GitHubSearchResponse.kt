package com.debanshu777.compose_github.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GitHubSearchResponse(
    @SerialName("incomplete_results")
    val incompleteResults: Boolean, // false
    @SerialName("items")
    val items: List<GitHubSearchUserList>,
    @SerialName("total_count")
    val totalCount: Int // 75872
)

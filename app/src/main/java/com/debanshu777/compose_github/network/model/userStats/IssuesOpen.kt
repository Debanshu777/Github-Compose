package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IssuesOpen(
    @SerialName("totalCount")
    val totalCount: Int = 0 // 0
)
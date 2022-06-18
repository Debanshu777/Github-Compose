package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RepositoriesX(
    @SerialName("nodes")
    val nodes: List<Node> = listOf(),
    @SerialName("totalCount")
    val totalCount: Int = 0, // 84
    @SerialName("totalDiskUsage")
    val totalDiskUsage: Int = 0 // 725538
)
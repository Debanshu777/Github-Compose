package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Edge(
    @SerialName("node")
    val node: NodeX = NodeX(),
    @SerialName("size")
    val size: Int = 0 // 126539
)
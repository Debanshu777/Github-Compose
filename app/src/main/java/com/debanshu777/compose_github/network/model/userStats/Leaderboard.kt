package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Leaderboard(
    @SerialName("percentile")
    val percentile: Double = 0.0, // 18.4909
    @SerialName("top")
    val top: Int = 0, // 1000000
    @SerialName("total")
    val total: Int = 0, // 92000000
    @SerialName("type")
    val type: String = "", // users
    @SerialName("user")
    val user: Int = 0 // 184909
)
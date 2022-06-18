package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Streak(
    @SerialName("current")
    val current: Int = 0, // 1
    @SerialName("max")
    val max: Int = 0 // 33
)
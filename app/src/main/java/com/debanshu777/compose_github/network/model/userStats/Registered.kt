package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Registered(
    @SerialName("months")
    val months: Int = 0, // 0
    @SerialName("years")
    val years: Double = 0.0 // 3.079397672826831
)
package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Hours(
    @SerialName("max")
    val max: Int = 0, // 1
    @SerialName("13")
    val x13: Int = 0, // 1
    @SerialName("16")
    val x16: Int = 0, // 1
    @SerialName("18")
    val x18: Int = 0, // 1
    @SerialName("20")
    val x20: Int = 0, // 1
    @SerialName("8")
    val x8: Int = 0 // 1
)
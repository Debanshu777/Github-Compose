package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Days(
    @SerialName("max")
    val max: Int = 0, // 3
    @SerialName("0")
    val x0: Int = 0, // 1
    @SerialName("4")
    val x4: Int = 0, // 3
    @SerialName("5")
    val x5: Int = 0 // 1
)
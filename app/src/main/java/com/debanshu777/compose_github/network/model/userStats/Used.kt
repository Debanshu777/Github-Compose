package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Used(
    @SerialName("Apache-2.0")
    val apache20: Int = 0, // 4
    @SerialName("GPL-3.0")
    val gPL30: Int = 0, // 1
    @SerialName("MIT")
    val mIT: Int = 0 // 5
)
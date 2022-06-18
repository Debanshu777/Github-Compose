package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PrX(
    @SerialName("closed")
    val closed: Int = 0, // 3
    @SerialName("count")
    val count: Int = 0, // 67
    @SerialName("drafts")
    val drafts: Int = 0, // 0
    @SerialName("merged")
    val merged: Int = 0, // 62
    @SerialName("open")
    val `open`: Int = 0 // 2
)
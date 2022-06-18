package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Following(
    @SerialName("totalCount")
    val totalCount: Int = 0 // 30
)
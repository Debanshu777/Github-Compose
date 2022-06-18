package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meta(
    @SerialName("author")
    val author: String = "", // lowlighter
    @SerialName("generated")
    val generated: String = "", // 17 Jun 2022, 20:52:50
    @SerialName("version")
    val version: String = "" // 3.24.0
)
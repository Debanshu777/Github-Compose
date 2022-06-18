package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MIT(
    @SerialName("name")
    val name: String = "", // MIT License
    @SerialName("spdxId")
    val spdxId: String = "" // MIT
)
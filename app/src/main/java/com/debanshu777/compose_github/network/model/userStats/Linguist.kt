package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Linguist(
    @SerialName("available")
    val available: Boolean = false, // false
    @SerialName("languages")
    val languages: Languages = Languages(),
)
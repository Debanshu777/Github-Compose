package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Introduction(
    @SerialName("mode")
    val mode: String = "", // user
    @SerialName("text")
    val text: String = "", // Android Engineer at @Gojek
    @SerialName("title")
    val title: Boolean = false // true
)
package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Indents(
    @SerialName("spaces")
    val spaces: Int = 0, // 0
    @SerialName("style")
    val style: String = "",
    @SerialName("tabs")
    val tabs: Int = 0 // 0
)
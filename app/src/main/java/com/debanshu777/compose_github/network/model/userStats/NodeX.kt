package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NodeX(
    @SerialName("color")
    val color: String? = null, // #A97BFF
    @SerialName("name")
    val name: String = "" // Kotlin
)
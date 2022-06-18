package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserStats(
    @SerialName("mime")
    val mime: String = "", // application/json
    @SerialName("rendered")
    val rendered: Rendered = Rendered()
)
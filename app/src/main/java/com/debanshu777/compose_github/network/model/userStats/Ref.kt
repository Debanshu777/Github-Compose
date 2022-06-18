package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Ref(
    @SerialName("name")
    val name: String? = null, // add-code-of-conduct-1
    @SerialName("type")
    val type: String = "" // branch
)
package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Lines(
    @SerialName("added")
    val added: Int = 0, // 128
    @SerialName("deleted")
    val deleted: Int = 0 // 0
)
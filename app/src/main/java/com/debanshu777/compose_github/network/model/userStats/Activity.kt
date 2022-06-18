package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Activity(
    @SerialName("events")
    val events: List<Event> = listOf(),
    @SerialName("timestamps")
    val timestamps: Boolean = false // false
)
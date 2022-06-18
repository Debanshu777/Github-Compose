package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Commits(
    @SerialName("day")
    val day: String = "", // Thursday
    @SerialName("days")
    val days: Days = Days(),
    @SerialName("fetched")
    val fetched: Int = 0, // 5
    @SerialName("hour")
    val hour: String = "", // 08
    @SerialName("hours")
    val hours: Hours = Hours()
)
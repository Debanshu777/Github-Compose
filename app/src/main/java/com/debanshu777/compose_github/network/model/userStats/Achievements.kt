package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Achievements(
    @SerialName("display")
    val display: String = "", // detailed
    @SerialName("list")
    val list: List<AchievementItem> = listOf()
)
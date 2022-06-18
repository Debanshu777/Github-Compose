package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Isocalendar(
    @SerialName("average")
    val average: String = "", // 1.73
    @SerialName("duration")
    val duration: String = "", // full-year
    @SerialName("max")
    val max: Int = 0, // 18
    @SerialName("streak")
    val streak: Streak = Streak(),
    @SerialName("svg")
    val svg: String = ""
)
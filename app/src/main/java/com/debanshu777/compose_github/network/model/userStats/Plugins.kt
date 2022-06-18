package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Plugins(
//    @SerialName("achievements")
//    val achievements: Achievements = Achievements(),
//    @SerialName("activity")
//    val activity: Activity = Activity(),
//    @SerialName("followup")
//    val followup: Followup = Followup(),
//    @SerialName("habits")
//    val habits: Habits = Habits(),
//    @SerialName("introduction")
//    val introduction: Introduction = Introduction(),
    @SerialName("isocalendar")
    val isocalendar: Isocalendar = Isocalendar(),
    @SerialName("languages")
    val languages: LanguagesX = LanguagesX(),
//    @SerialName("notable")
//    val notable: Notable = Notable()
)
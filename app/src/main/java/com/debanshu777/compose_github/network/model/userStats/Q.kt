package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Q(
    @SerialName("achievements")
    val achievements: Boolean = false, // true
    @SerialName("achievements.threshold")
    val achievementsThreshold: String = "", // X
    @SerialName("activity")
    val activity: Boolean = false, // true
    @SerialName("activity.days")
    val activityDays: Int = 0, // 0
    @SerialName("activity.limit")
    val activityLimit: Int = 0, // 100
    @SerialName("followup")
    val followup: Boolean = false, // true
    @SerialName("followup.sections")
    val followupSections: String = "", // repositories, user
    @SerialName("habits")
    val habits: Boolean = false, // true
    @SerialName("habits.charts")
    val habitsCharts: Boolean = false, // true
    @SerialName("habits.days")
    val habitsDays: Int = 0, // 7
    @SerialName("habits.facts")
    val habitsFacts: Boolean = false, // false
    @SerialName("habits.from")
    val habitsFrom: Int = 0, // 100
    @SerialName("introduction")
    val introduction: Boolean = false, // true
    @SerialName("isocalendar")
    val isocalendar: Boolean = false, // true
    @SerialName("isocalendar.duration")
    val isocalendarDuration: String = "", // full-year
    @SerialName("languages")
    val languages: Boolean = false, // true
    @SerialName("languages.limit")
    val languagesLimit: Int = 0, // 0
    @SerialName("notable")
    val notable: Boolean = false, // true
    @SerialName("template")
    val template: String = "" // classic
)
package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CalendarX(
    @SerialName("contributionCalendar")
    val contributionCalendar: ContributionCalendar = ContributionCalendar()
)
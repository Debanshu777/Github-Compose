package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IssuesX(
    @SerialName("closed")
    val closed: Int = 0, // 2
    @SerialName("count")
    val count: Int = 0, // 2
    @SerialName("drafts")
    val drafts: Int = 0, // 0
    @SerialName("open")
    val `open`: Int = 0, // 0
    @SerialName("skipped")
    val skipped: Int = 0 // 0
)
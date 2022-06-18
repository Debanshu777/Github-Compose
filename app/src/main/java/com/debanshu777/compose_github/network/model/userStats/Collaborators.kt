package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Collaborators(
    @SerialName("closed")
    val closed: Int = 0, // 0
    @SerialName("drafts")
    val drafts: Int = 0, // 0
    @SerialName("open")
    val `open`: Int = 0, // 0
    @SerialName("skipped")
    val skipped: Int = 0 // 0
)
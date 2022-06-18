package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Issues(
    @SerialName("closed")
    val closed: Int = 0, // 4
    @SerialName("collaborators")
    val collaborators: Collaborators = Collaborators(),
    @SerialName("count")
    val count: Int = 0, // 5
    @SerialName("drafts")
    val drafts: Int = 0, // 0
    @SerialName("open")
    val `open`: Int = 0, // 1
    @SerialName("skipped")
    val skipped: Int = 0 // 0
)
package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Commit(
    @SerialName("message")
    val message: String = "", // Adding UI for Pinned Projects in profile screen
    @SerialName("sha")
    val sha: String = "" // c182012
)
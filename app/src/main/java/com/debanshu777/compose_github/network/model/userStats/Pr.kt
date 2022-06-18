package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pr(
    @SerialName("closed")
    val closed: Int = 0, // 15
    @SerialName("collaborators")
    val collaborators: CollaboratorsX = CollaboratorsX(),
    @SerialName("count")
    val count: Int = 0, // 117
    @SerialName("drafts")
    val drafts: Int = 0, // 0
    @SerialName("merged")
    val merged: Int = 0, // 74
    @SerialName("open")
    val `open`: Int = 0 // 28
)
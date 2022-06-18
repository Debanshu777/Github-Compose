package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CollaboratorsX(
    @SerialName("closed")
    val closed: Int = 0, // 0
    @SerialName("drafts")
    val drafts: Int = 0, // 0
    @SerialName("merged")
    val merged: Int = 0, // 0
    @SerialName("open")
    val `open`: Int = 0 // 0
)
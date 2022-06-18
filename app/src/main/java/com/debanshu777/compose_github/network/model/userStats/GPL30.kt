package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GPL30(
    @SerialName("name")
    val name: String = "", // GNU General Public License v3.0
    @SerialName("spdxId")
    val spdxId: String = "" // GPL-3.0
)
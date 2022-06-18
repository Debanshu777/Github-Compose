package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Apache20(
    @SerialName("name")
    val name: String = "", // Apache License 2.0
    @SerialName("spdxId")
    val spdxId: String = "" // Apache-2.0
)
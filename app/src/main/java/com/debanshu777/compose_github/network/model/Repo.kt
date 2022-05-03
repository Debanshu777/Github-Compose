package com.debanshu777.compose_github.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Repo(
    @SerialName("description")
    val description: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("url")
    val url: String?
)

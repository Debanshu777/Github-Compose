package com.debanshu777.compose_github.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BuiltBy(
    @SerialName("avatar")
    val avatar: String?,
    @SerialName("href")
    val href: String?,
    @SerialName("username")
    val username: String?
)
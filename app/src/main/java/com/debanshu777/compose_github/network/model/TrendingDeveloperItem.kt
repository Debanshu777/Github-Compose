package com.debanshu777.compose_github.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrendingDeveloperItem(
    @SerialName("avatar")
    val avatar: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("repo")
    val repo: Repo?,
    @SerialName("sponsorUrl")
    val sponsorUrl: String?,
    @SerialName("url")
    val url: String?,
    @SerialName("username")
    val username: String?
)

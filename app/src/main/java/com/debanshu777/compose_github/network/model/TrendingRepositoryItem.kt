package com.debanshu777.compose_github.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrendingRepositoryItem(
    @SerialName("author")
    val author: String?,
    @SerialName("avatar")
    val avatar: String?,
    @SerialName("builtBy")
    val builtBy: List<BuiltBy>?,
    @SerialName("currentPeriodStars")
    val currentPeriodStars: Int?,
    @SerialName("description")
    val description: String?,
    @SerialName("forks")
    val forks: Int?,
    @SerialName("language")
    val language: String?,
    @SerialName("languageColor")
    val languageColor: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("stars")
    val stars: Int?,
    @SerialName("url")
    val url: String?
)
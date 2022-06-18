package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Licenses(
    @SerialName("about")
    val about: About = About(),
    @SerialName("favorite")
    val favorite: List<String> = listOf(),
    @SerialName("used")
    val used: Used = Used()
)
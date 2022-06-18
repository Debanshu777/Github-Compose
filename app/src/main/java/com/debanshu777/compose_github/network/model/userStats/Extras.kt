package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Extras(
    @SerialName("css")
    val css: String = "",
    @SerialName("js")
    val js: String = ""
)
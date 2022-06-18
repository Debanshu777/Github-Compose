package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Base(
    @SerialName("activity")
    val activity: Boolean = false, // true
    @SerialName("community")
    val community: Boolean = false, // true
    @SerialName("header")
    val header: Boolean = false, // true
    @SerialName("metadata")
    val metadata: Boolean = false, // true
    @SerialName("repositories")
    val repositories: Boolean = false // true
)
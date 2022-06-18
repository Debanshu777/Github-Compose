package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Notable(
    @SerialName("contributions")
    val contributions: List<Contribution> = listOf(),
    @SerialName("types")
    val types: List<String> = listOf()
)
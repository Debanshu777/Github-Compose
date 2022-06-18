package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Shared(
    @SerialName("commits.authoring")
    val commitsAuthoring: List<String> = listOf(),
    @SerialName("repositories.batch")
    val repositoriesBatch: Int = 0, // 100
    @SerialName("users.ignored")
    val usersIgnored: List<String> = listOf()
)
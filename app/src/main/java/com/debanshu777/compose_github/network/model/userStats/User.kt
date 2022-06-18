package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("issues")
    val issues: IssuesX = IssuesX(),
    @SerialName("pr")
    val pr: PrX = PrX()
)
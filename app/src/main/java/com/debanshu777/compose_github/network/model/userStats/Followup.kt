package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Followup(
    @SerialName("issues")
    val issues: Issues = Issues(),
    @SerialName("pr")
    val pr: Pr = Pr(),
    @SerialName("sections")
    val sections: List<String> = listOf(),
    @SerialName("user")
    val user: User = User()
)
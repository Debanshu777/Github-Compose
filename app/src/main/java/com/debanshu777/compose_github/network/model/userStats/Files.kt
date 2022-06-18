package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Files(
    @SerialName("changed")
    val changed: Int = 0 // 1
)
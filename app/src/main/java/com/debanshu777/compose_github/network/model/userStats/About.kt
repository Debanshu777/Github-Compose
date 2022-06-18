package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class About(
    @SerialName("Apache-2.0")
    val apache20: Apache20 = Apache20(),
    @SerialName("GPL-3.0")
    val gPL30: GPL30 = GPL30(),
    @SerialName("MIT")
    val mIT: MIT = MIT()
)
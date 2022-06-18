package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Favorite(
    @SerialName("color")
    val color: String = "", // #DA5B0B
    @SerialName("lines")
    val lines: Int = 0, // 0
    @SerialName("name")
    val name: String = "", // Jupyter Notebook
    @SerialName("size")
    val size: Int = 0, // 3138110
    @SerialName("value")
    val value: Double = 0.0, // 0.5131594288595129
    @SerialName("x")
    val x: Double = 0.0 // 0.5131594288595129
)
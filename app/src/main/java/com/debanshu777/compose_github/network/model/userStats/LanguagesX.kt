package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LanguagesX(
    @SerialName("colors")
    val colors: Colors = Colors(),
    @SerialName("favorites")
    val favorites: List<Favorite> = listOf(),
    @SerialName("indepth")
    val indepth: Boolean = false, // false
    @SerialName("sections")
    val sections: List<String> = listOf(),
    @SerialName("stats")
    val stats: Stats = Stats(),
    @SerialName("stats.recent")
    val statsRecent: StatsRecent = StatsRecent(),
    @SerialName("total")
    val total: Int = 0, // 6115273
    @SerialName("unique")
    val unique: Int = 0 // 22
)
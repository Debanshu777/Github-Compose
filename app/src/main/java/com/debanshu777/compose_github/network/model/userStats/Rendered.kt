package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Rendered(
//    @SerialName("account")
//    val account: String = "", // user
//    @SerialName("animated")
//    val animated: Boolean = false, // true
//    @SerialName("base")
//    val base: Base = Base(),
//    @SerialName("columns")
//    val columns: Boolean = false, // false
//    @SerialName("computed")
//    val computed: Computed = Computed(),
//    @SerialName("config")
//    val config: Config = Config(),
//    @SerialName("extras")
//    val extras: Extras = Extras(),
//    @SerialName("large")
//    val large: Boolean = false, // false
//    @SerialName("meta")
//    val meta: Meta = Meta(),
//    @SerialName("partials")
//    val partials: List<String> = listOf(),
    @SerialName("plugins")
    val plugins: Plugins = Plugins(),
//    @SerialName("q")
//    val q: Q = Q(),
//    @SerialName("shared")
//    val shared: Shared = Shared(),
//    @SerialName("user")
//    val user: UserX = UserX()
)
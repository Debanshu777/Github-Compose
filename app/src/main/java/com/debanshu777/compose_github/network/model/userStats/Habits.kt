package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Habits(
    @SerialName("charts")
    val charts: Boolean = false, // true
    @SerialName("commits")
    val commits: Commits = Commits(),
    @SerialName("facts")
    val facts: Boolean = false, // false
    @SerialName("indents")
    val indents: Indents = Indents(),
    @SerialName("linguist")
    val linguist: Linguist = Linguist(),
    @SerialName("trim")
    val trim: Boolean = false // false
)
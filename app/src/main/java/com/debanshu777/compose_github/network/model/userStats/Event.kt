package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Event(
    @SerialName("action")
    val action: String? = null, // merged
    @SerialName("actor")
    val actor: String = "", // Debanshu777
    @SerialName("branch")
    val branch: String? = null, // master
    @SerialName("commits")
    val commits: List<Commit>? = null,
    @SerialName("content")
    val content: String? = null,
    @SerialName("files")
    val files: Files? = null,
    @SerialName("forked")
    val forked: String? = null, // Debanshu777/GitHubGraduation-2022
    @SerialName("lines")
    val lines: Lines? = null,
    @SerialName("number")
    val number: Int? = null, // 3
    @SerialName("ref")
    val ref: Ref? = null,
    @SerialName("repo")
    val repo: String = "", // Debanshu777/Compose-Github
    @SerialName("size")
    val size: Int? = null, // 2
    @SerialName("timestamp")
    val timestamp: String = "", // 2022-06-17T20:32:41.000Z
    @SerialName("title")
    val title: String? = null, // Create CODE_OF_CONDUCT.md
    @SerialName("type")
    val type: String = "", // push
    @SerialName("user")
    val user: String? = null // Debanshu777
)
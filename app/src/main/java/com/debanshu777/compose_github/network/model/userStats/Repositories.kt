package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Repositories(
    @SerialName("deployments")
    val deployments: Int = 0, // 6
    @SerialName("environments")
    val environments: Int = 0, // 2
    @SerialName("forked")
    val forked: Int = 0, // 0
    @SerialName("forks")
    val forks: Int = 0, // 35
    @SerialName("issues_closed")
    val issuesClosed: Int = 0, // 4
    @SerialName("issues_open")
    val issuesOpen: Int = 0, // 1
    @SerialName("pr_closed")
    val prClosed: Int = 0, // 15
    @SerialName("pr_merged")
    val prMerged: Int = 0, // 74
    @SerialName("pr_open")
    val prOpen: Int = 0, // 28
    @SerialName("releases")
    val releases: Int = 0, // 0
    @SerialName("stargazers")
    val stargazers: Int = 0, // 106
    @SerialName("watchers")
    val watchers: Int = 0 // 55
)
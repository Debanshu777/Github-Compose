package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Node(
    @SerialName("deployments")
    val deployments: Deployments = Deployments(),
    @SerialName("environments")
    val environments: Environments = Environments(),
    @SerialName("forkCount")
    val forkCount: Int = 0, // 9
    @SerialName("isFork")
    val isFork: Boolean = false, // false
    @SerialName("issues_closed")
    val issuesClosed: IssuesClosed = IssuesClosed(),
    @SerialName("issues_open")
    val issuesOpen: IssuesOpen = IssuesOpen(),
    @SerialName("languages")
    val languages: LanguagesXX = LanguagesXX(),
    @SerialName("licenseInfo")
    val licenseInfo: LicenseInfo? = LicenseInfo(),
    @SerialName("name")
    val name: String = "", // Compose-Snapchat-Clone
    @SerialName("owner")
    val owner: Owner = Owner(),
    @SerialName("pr_closed")
    val prClosed: PrClosed = PrClosed(),
    @SerialName("pr_merged")
    val prMerged: PrMerged = PrMerged(),
    @SerialName("pr_open")
    val prOpen: PrOpen = PrOpen(),
    @SerialName("releases")
    val releases: Releases = Releases(),
    @SerialName("stargazers")
    val stargazers: Stargazers = Stargazers(),
    @SerialName("watchers")
    val watchers: Watchers = Watchers()
)
package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NodeXX(
    @SerialName("deployments")
    val deployments: DeploymentsX = DeploymentsX(),
    @SerialName("environments")
    val environments: EnvironmentsX = EnvironmentsX(),
    @SerialName("forkCount")
    val forkCount: Int = 0, // 6696
    @SerialName("isFork")
    val isFork: Boolean = false, // false
    @SerialName("issues_closed")
    val issuesClosed: IssuesClosedX = IssuesClosedX(),
    @SerialName("issues_open")
    val issuesOpen: IssuesOpenX = IssuesOpenX(),
    @SerialName("name")
    val name: String = "", // GitHubGraduation-2022
    @SerialName("owner")
    val owner: OwnerX = OwnerX(),
    @SerialName("pr_closed")
    val prClosed: PrClosedX = PrClosedX(),
    @SerialName("pr_merged")
    val prMerged: PrMergedX = PrMergedX(),
    @SerialName("pr_open")
    val prOpen: PrOpenX = PrOpenX(),
    @SerialName("releases")
    val releases: Releases = Releases(),
    @SerialName("stargazers")
    val stargazers: StargazersX = StargazersX(),
    @SerialName("watchers")
    val watchers: WatchersX = WatchersX()
)
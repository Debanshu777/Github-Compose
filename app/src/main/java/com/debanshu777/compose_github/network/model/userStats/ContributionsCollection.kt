package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContributionsCollection(
    @SerialName("restrictedContributionsCount")
    val restrictedContributionsCount: Int = 0, // 314
    @SerialName("totalCommitContributions")
    val totalCommitContributions: Int = 0, // 736
    @SerialName("totalIssueContributions")
    val totalIssueContributions: Int = 0, // 2
    @SerialName("totalPullRequestContributions")
    val totalPullRequestContributions: Int = 0, // 38
    @SerialName("totalPullRequestReviewContributions")
    val totalPullRequestReviewContributions: Int = 0, // 0
    @SerialName("totalRepositoriesWithContributedCommits")
    val totalRepositoriesWithContributedCommits: Int = 0 // 20
)
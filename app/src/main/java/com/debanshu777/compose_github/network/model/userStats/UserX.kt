package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserX(
    @SerialName("avatarUrl")
    val avatarUrl: String = "", // https://avatars.githubusercontent.com/u/50791485?u=3dd73ecc130dcd69d1b9597c0f323c7570145ef2&v=4
    @SerialName("calendar")
    val calendar: CalendarX = CalendarX(),
    @SerialName("contributionsCollection")
    val contributionsCollection: ContributionsCollection = ContributionsCollection(),
    @SerialName("createdAt")
    val createdAt: String = "", // 2019-05-19T07:01:30Z
    @SerialName("databaseId")
    val databaseId: Int = 0, // 50791485
    @SerialName("followers")
    val followers: Followers = Followers(),
    @SerialName("following")
    val following: Following = Following(),
    @SerialName("isHireable")
    val isHireable: Boolean = false, // false
    @SerialName("isVerified")
    val isVerified: Boolean = false, // false
    @SerialName("issueComments")
    val issueComments: IssueComments = IssueComments(),
    @SerialName("location")
    val location: String = "", // Kolkata | Bangalore
    @SerialName("login")
    val login: String = "", // Debanshu777
    @SerialName("name")
    val name: String = "", // Debanshu Datta
    @SerialName("organizations")
    val organizations: Organizations = Organizations(),
    @SerialName("packages")
    val packages: Packages = Packages(),
    @SerialName("repositories")
    val repositories: RepositoriesX = RepositoriesX(),
    @SerialName("repositoriesContributedTo")
    val repositoriesContributedTo: RepositoriesContributedTo = RepositoriesContributedTo(),
    @SerialName("sponsorshipsAsMaintainer")
    val sponsorshipsAsMaintainer: SponsorshipsAsMaintainer = SponsorshipsAsMaintainer(),
    @SerialName("sponsorshipsAsSponsor")
    val sponsorshipsAsSponsor: SponsorshipsAsSponsor = SponsorshipsAsSponsor(),
    @SerialName("starredRepositories")
    val starredRepositories: StarredRepositories = StarredRepositories(),
    @SerialName("twitterUsername")
    val twitterUsername: String = "", // DattaDebanshu
    @SerialName("watching")
    val watching: Watching = Watching(),
    @SerialName("websiteUrl")
    val websiteUrl: String = "" // https://www.linkedin.com/in/debanshu-datta-483376169/
)
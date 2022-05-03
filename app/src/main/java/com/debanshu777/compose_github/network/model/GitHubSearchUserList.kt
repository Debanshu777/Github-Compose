package com.debanshu777.compose_github.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GitHubSearchUserList(
    @SerialName("avatar_url")
    val avatarUrl: String?, // https://avatars.githubusercontent.com/u/27942?v=4
    @SerialName("events_url")
    val eventsUrl: String?, // https://api.github.com/users/anu/events{/privacy}
    @SerialName("followers_url")
    val followersUrl: String?, // https://api.github.com/users/anu/followers
    @SerialName("following_url")
    val followingUrl: String?, // https://api.github.com/users/anu/following{/other_user}
    @SerialName("gists_url")
    val gistsUrl: String?, // https://api.github.com/users/anu/gists{/gist_id}
    @SerialName("gravatar_id")
    val gravatarId: String?,
    @SerialName("html_url")
    val htmlUrl: String?, // https://github.com/anu
    @SerialName("id")
    val id: Int?, // 27942
    @SerialName("login")
    val login: String?, // anu
    @SerialName("node_id")
    val nodeId: String?, // MDQ6VXNlcjI3OTQy
    @SerialName("organizations_url")
    val organizationsUrl: String?, // https://api.github.com/users/anu/orgs
    @SerialName("received_events_url")
    val receivedEventsUrl: String?, // https://api.github.com/users/anu/received_events
    @SerialName("repos_url")
    val reposUrl: String?, // https://api.github.com/users/anu/repos
    @SerialName("score")
    val score: Float?, // 1
    @SerialName("site_admin")
    val siteAdmin: Boolean?, // false
    @SerialName("starred_url")
    val starredUrl: String?, // https://api.github.com/users/anu/starred{/owner}{/repo}
    @SerialName("subscriptions_url")
    val subscriptionsUrl: String?, // https://api.github.com/users/anu/subscriptions
    @SerialName("type")
    val type: String?, // User
    @SerialName("url")
    val url: String? // https://api.github.com/users/anu
)

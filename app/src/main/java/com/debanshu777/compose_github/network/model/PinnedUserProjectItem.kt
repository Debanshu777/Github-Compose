package com.debanshu777.compose_github.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PinnedUserProjectItem(
    @SerialName("description")
    val description: String? = null, // Snapchat Clone with Jetpack Compose and Clean Architecture - Navigation Components, CamaraX, android-maps-compose, Exoplayer, Detekt, Coil, Gradle Secrets, Permission Handling.
    @SerialName("forks")
    val forks: Int?, // 0
    @SerialName("image")
    val image: String?, // https://opengraph.githubassets.com/1/Debanshu777/Compose-Snapchat-Clone
    @SerialName("language")
    val language: String?, // Kotlin
    @SerialName("languageColor")
    val languageColor: String?, // #A97BFF
    @SerialName("link")
    val link: String?, // https://github.com/Debanshu777/Compose-Snapchat-Clone
    @SerialName("owner")
    val owner: String?, // Debanshu777
    @SerialName("repo")
    val repo: String?, // Compose-Snapchat-Clone
    @SerialName("stars")
    val stars: String?, // 47
    @SerialName("website")
    val website: String? = null // https://snapchat-clone-debanshu777.netlify.app/
)
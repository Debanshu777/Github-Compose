package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AchievementItem(
    @SerialName("icon")
    val icon: String = "", // <g stroke-linecap="round" stroke-width="2" fill="none" fill-rule="evenodd"><path d="M17.135 7.988l-3.303.669a2 2 0 00-1.586 2.223l4.708 35.392a1.498 1.498 0 01-1.162 1.66 1.523 1.523 0 01-1.775-1.01L4.951 19.497a2 2 0 011.215-2.507l2.946-1.072" stroke="#731237" stroke-linejoin="round"/><path d="M36.8 48H23a2 2 0 01-2-2V7a2 2 0 012-2h26a2 2 0 012 2v32.766" stroke="#EB355E"/><path d="M29 20.955l-3.399 3.399a.85.85 0 000 1.202l3.399 3.4M43.014 20.955l3.399 3.399a.85.85 0 010 1.202l-3.4 3.4" stroke="#EB355E" stroke-linejoin="round"/><path stroke="#EB355E" d="M38.526 18l-5.053 14.016"/><path d="M44 36a8 8 0 110 16 8 8 0 010-16z" stroke="#EB355E" stroke-linejoin="round"/><path d="M43.068 40.749l3.846 2.396a1 1 0 01-.006 1.7l-3.846 2.36a1 1 0 01-1.523-.853v-4.755a1 1 0 011.529-.848z" stroke="#EB355E" stroke-linejoin="round"/></g>
    @SerialName("prefix")
    val prefix: String = "", // Master
    @SerialName("progress")
    val progress: Double = 0.0, // 0.375
    @SerialName("rank")
    val rank: String = "", // S
    @SerialName("text")
    val text: String = "", // Using 22 different programming languages
    @SerialName("title")
    val title: String = "", // Polyglot
    @SerialName("value")
    val value: Int = 0 // 22
)
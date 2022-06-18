package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Colors(
    @SerialName("Batchfile")
    val batchfile: String = "", // #C1F12E
    @SerialName("C++")
    val cpp: String = "", // #f34b7d
    @SerialName("C")
    val c: String = "", // #555555
    @SerialName("CMake")
    val cMake: String = "", // #DA3434
    @SerialName("CSS")
    val cSS: String = "", // #563d7c
    @SerialName("Dart")
    val dart: String = "", // #00B4AB
    @SerialName("Dockerfile")
    val dockerfile: String = "", // #384d54
    @SerialName("Go")
    val go: String = "", // #00ADD8
    @SerialName("HTML")
    val hTML: String = "", // #e34c26
    @SerialName("Java")
    val java: String = "", // #b07219
    @SerialName("JavaScript")
    val javaScript: String = "", // #f1e05a
    @SerialName("Jupyter Notebook")
    val jupyterNotebook: String = "", // #DA5B0B
    @SerialName("Kotlin")
    val kotlin: String = "", // #A97BFF
    @SerialName("Makefile")
    val makefile: String = "", // #427819
    @SerialName("Objective-C")
    val objectiveC: String = "", // #438eff
    @SerialName("PowerShell")
    val powerShell: String = "", // #012456
    @SerialName("Python")
    val python: String = "", // #3572A5
    @SerialName("Ruby")
    val ruby: String = "", // #701516
    @SerialName("Shell")
    val shell: String = "", // #89e051
    @SerialName("Swift")
    val swift: String = "", // #F05138
    @SerialName("TypeScript")
    val typeScript: String = "" // #3178c6
)
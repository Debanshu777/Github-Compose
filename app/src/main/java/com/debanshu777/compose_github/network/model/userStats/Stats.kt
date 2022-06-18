package com.debanshu777.compose_github.network.model.userStats


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Stats(
    @SerialName("Batchfile")
    val batchfile: Int = 0, // 1299
    @SerialName("C++")
    val cpp: Int = 0, // 20935
    @SerialName("C")
    val c: Int = 0, // 1619
    @SerialName("CMake")
    val cMake: Int = 0, // 18162
    @SerialName("CSS")
    val cSS: Int = 0, // 2823
    @SerialName("Dart")
    val dart: Int = 0, // 263337
    @SerialName("Dockerfile")
    val dockerfile: Int = 0, // 349
    @SerialName("Go")
    val go: Int = 0, // 1477
    @SerialName("HTML")
    val hTML: Int = 0, // 9860
    @SerialName("Java")
    val java: Int = 0, // 682966
    @SerialName("JavaScript")
    val javaScript: Int = 0, // 65508
    @SerialName("Jupyter Notebook")
    val jupyterNotebook: Int = 0, // 3138110
    @SerialName("Kotlin")
    val kotlin: Int = 0, // 489205
    @SerialName("Makefile")
    val makefile: Int = 0, // 154
    @SerialName("Objective-C")
    val objectiveC: Int = 0, // 5460
    @SerialName("PowerShell")
    val powerShell: Int = 0, // 17772
    @SerialName("Python")
    val python: Int = 0, // 1372108
    @SerialName("Rich Text Format")
    val richTextFormat: Int = 0, // 7
    @SerialName("Ruby")
    val ruby: Int = 0, // 11116
    @SerialName("Shell")
    val shell: Int = 0, // 5687
    @SerialName("Swift")
    val swift: Int = 0, // 3259
    @SerialName("TypeScript")
    val typeScript: Int = 0 // 4060
)
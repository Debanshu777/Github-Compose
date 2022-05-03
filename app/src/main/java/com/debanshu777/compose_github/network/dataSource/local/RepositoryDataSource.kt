package com.debanshu777.compose_github.network.dataSource.local

import composedb.githubDB.RepositoryFollow
import kotlinx.coroutines.flow.Flow

interface RepositoryDataSource {
    suspend fun getRepositoryById(id: Long): RepositoryFollow?

    suspend fun getRepositoryByName(name: String): RepositoryFollow?

    fun getAllRepository(): Flow<List<RepositoryFollow>>

    suspend fun deleteRepositoryById(id: Long)

    suspend fun insertRepository(
        id: Long? = null,
        authorName: String,
        name: String,
        avatar: String,
        description: String,
        language: String,
        languageColor: String,
        forks: Long,
        stars: Long
    )
}

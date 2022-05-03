package com.debanshu777.compose_github.network.dataSource.local

import composedb.githubDB.DeveloperFollow
import kotlinx.coroutines.flow.Flow

interface DeveloperDataSource {
    suspend fun getDeveloperById(Id: Long): DeveloperFollow?

    suspend fun getDeveloperByName(name: String): DeveloperFollow?

    fun getAllDeveloper(): Flow<List<DeveloperFollow>>

    suspend fun deleteDeveloperById(id: Long)

    suspend fun insertDeveloper(
        id: Long? = null,
        userName: String,
        name: String,
        avatar: String,
    )
}

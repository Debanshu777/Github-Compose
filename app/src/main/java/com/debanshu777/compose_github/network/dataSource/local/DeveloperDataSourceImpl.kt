package com.debanshu777.compose_github.network.dataSource.local

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.debanshu777.compose_github.GithubDatatbase
import composedb.githubDB.DeveloperFollow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class DeveloperDataSourceImpl(
    db: GithubDatatbase
) : DeveloperDataSource {
    private val queries = db.developerFollowQueries
    override suspend fun getDeveloperById(Id: Long): DeveloperFollow? {
        return withContext(Dispatchers.IO) {
            queries.getDeveloperById(Id).executeAsOneOrNull()
        }
    }

    override suspend fun getDeveloperByName(name: String): DeveloperFollow? {
        return withContext(Dispatchers.IO) {
            queries.getDeveloperByName(name).executeAsOneOrNull()
        }
    }

    override fun getAllDeveloper(): Flow<List<DeveloperFollow>> =
            queries.getAllDeveloper()
                .asFlow()
                .mapToList(Dispatchers.IO)

    override suspend fun deleteDeveloperById(id: Long) {
        return withContext(Dispatchers.IO) {
            queries.deleteDeveloperById(id)
        }
    }

    override suspend fun insertDeveloper(
        id: Long?,
        userName: String,
        name: String,
        avatar: String
    ) {
        return withContext(Dispatchers.IO) {
            queries.insertDeveloper(
                id,
                userName,
                name,
                avatar,
            )
        }
    }
}

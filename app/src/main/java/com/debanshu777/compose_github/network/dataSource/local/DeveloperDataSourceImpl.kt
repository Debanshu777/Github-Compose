package com.debanshu777.compose_github.network.dataSource.local

import com.debanshu777.compose_github.GithubDatatbase
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import composedb.githubDB.DeveloperFollow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

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

    override fun getAllDeveloper(): Flow<List<DeveloperFollow>> {
        return queries.getAllDeveloper().asFlow().mapToList()
    }

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

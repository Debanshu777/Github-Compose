package com.debanshu777.compose_github.network.dataSource.local

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.debanshu777.compose_github.GithubDatatbase
import composedb.githubDB.RepositoryFollow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class RepositoryDataSourceImpl(
    db: GithubDatatbase
) : RepositoryDataSource {
    private val queries = db.repositoryFollowQueries
    override suspend fun getRepositoryById(id: Long): RepositoryFollow? {
        return withContext(Dispatchers.IO) {
            queries.getRepositoryById(id).executeAsOneOrNull()
        }
    }

    override suspend fun getRepositoryByName(name: String): RepositoryFollow? {
        return withContext(Dispatchers.IO) {
            queries.getRepositoryByName(name).executeAsOneOrNull()
        }
    }

    override fun getAllRepository(): Flow<List<RepositoryFollow>> {
        return queries.getAllRepository().asFlow().mapToList(Dispatchers.IO)
    }

    override suspend fun deleteRepositoryById(id: Long) {
        return withContext(Dispatchers.IO) {
            queries.deleteRepositoryById(id)
        }
    }

    override suspend fun insertRepository(
        id: Long?,
        authorName: String,
        name: String,
        avatar: String,
        description: String,
        language: String,
        languageColor: String,
        forks: Long,
        stars: Long
    ) {
        return withContext(Dispatchers.IO) {
            queries.insertRepository(
                id,
                authorName,
                name,
                avatar,
                description,
                language,
                languageColor,
                forks,
                stars
            )
        }
    }
}

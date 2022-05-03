package com.debanshu777.compose_github.network.dataSource.local

import com.debanshu777.compose_github.GithubDatatbase
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import composedb.githubDB.RepositoryFollow
import dagger.Component
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryDataSourceImpl(
    db: GithubDatatbase
):RepositoryDataSource {
    private val queries = db.repositoryFollowQueries
    override suspend fun getRepositoryById(id: Long): RepositoryFollow? {
        return withContext(Dispatchers.IO){
            queries.getRepositoryById(id).executeAsOneOrNull()
        }
    }

    override suspend fun getRepositoryByName(name: String): RepositoryFollow? {
        return withContext(Dispatchers.IO){
            queries.getRepositoryByName(name).executeAsOneOrNull()
        }
    }

    override fun getAllRepository(): Flow<List<RepositoryFollow>> {
        return queries.getAllRepository().asFlow().mapToList()
    }

    override suspend fun deleteRepositoryById(id: Long) {
        return withContext(Dispatchers.IO){
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
        return withContext(Dispatchers.IO){
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
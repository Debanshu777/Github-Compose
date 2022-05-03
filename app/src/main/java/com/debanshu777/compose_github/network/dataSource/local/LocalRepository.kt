package com.debanshu777.compose_github.network.dataSource.local

import composedb.githubDB.DeveloperFollow
import composedb.githubDB.RepositoryFollow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalRepository @Inject constructor(
    private val developerDataSourceImpl: DeveloperDataSource,
    private val repositoryDataSourceImpl: RepositoryDataSource
) {
    suspend fun getRepositoryById(id: Long): RepositoryFollow?{
        return repositoryDataSourceImpl.getRepositoryById(id)
    }
    suspend fun getDeveloperById(Id: Long): DeveloperFollow?{
        return developerDataSourceImpl.getDeveloperById(Id);
    }

    suspend fun getRepositoryByName(name: String): RepositoryFollow?{
        return repositoryDataSourceImpl.getRepositoryByName(name)
    }
    suspend fun getDeveloperByName(name: String): DeveloperFollow? {
        return developerDataSourceImpl.getDeveloperByName(name)
    }

    fun getAllRepository(): Flow<List<RepositoryFollow>>{
        return repositoryDataSourceImpl.getAllRepository()
    }
    fun getAllDeveloper(): Flow<List<DeveloperFollow>> {
        return developerDataSourceImpl.getAllDeveloper()
    }

    suspend fun deleteRepositoryById(id: Long) {
        return repositoryDataSourceImpl.deleteRepositoryById(id)
    }
    suspend fun deleteDeveloperById(id: Long) {
        return developerDataSourceImpl.deleteDeveloperById(id)
    }

    suspend fun insertRepository(
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
        return repositoryDataSourceImpl.insertRepository(
            id, authorName,name,avatar,description,language,languageColor,forks, stars
        )
    }

    suspend fun insertDeveloper(
        id: Long?,
        userName: String,
        name: String,
        avatar: String
    ) {
        return developerDataSourceImpl.insertDeveloper(
            id, userName,name,avatar
        )
    }
}
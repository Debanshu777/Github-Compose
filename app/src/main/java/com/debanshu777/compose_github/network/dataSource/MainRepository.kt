package com.debanshu777.compose_github.network.dataSource

import com.debanshu777.compose_github.network.dataSource.local.LocalRepository
import com.debanshu777.compose_github.network.dataSource.remote.RemoteRepository
import com.debanshu777.compose_github.network.model.GitHubSearchResponse
import com.debanshu777.compose_github.network.model.GitHubUserResponse
import com.debanshu777.compose_github.network.model.PinnedUserProjectItem
import com.debanshu777.compose_github.network.model.TrendingDeveloperItem
import com.debanshu777.compose_github.network.model.TrendingRepositoryItem
import com.debanshu777.compose_github.utils.Resource
import composedb.githubDB.DeveloperFollow
import composedb.githubDB.RepositoryFollow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
) {
    suspend fun getRepositoryById(id: Long): RepositoryFollow? {
        return localRepository.getRepositoryById(id)
    }
    suspend fun getDeveloperById(Id: Long): DeveloperFollow? {
        return localRepository.getDeveloperById(Id)
    }

    suspend fun getRepositoryByName(name: String): RepositoryFollow? {
        return localRepository.getRepositoryByName(name)
    }
    suspend fun getDeveloperByName(name: String): DeveloperFollow? {
        return localRepository.getDeveloperByName(name)
    }

    fun getAllRepository(): Flow<List<RepositoryFollow>> {
        return localRepository.getAllRepository()
    }
    fun getAllDeveloper(): Flow<List<DeveloperFollow>> {
        return localRepository.getAllDeveloper()
    }

    suspend fun deleteRepositoryById(id: Long) {
        return localRepository.deleteRepositoryById(id)
    }
    suspend fun deleteDeveloperById(id: Long) {
        return localRepository.deleteDeveloperById(id)
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
        return localRepository.insertRepository(
            id, authorName, name, avatar, description, language, languageColor, forks, stars
        )
    }

    suspend fun insertDeveloper(
        id: Long?,
        userName: String,
        name: String,
        avatar: String
    ) {
        return localRepository.insertDeveloper(
            id, userName, name, avatar
        )
    }

    suspend fun getUserData(userId: String): Resource<GitHubUserResponse> {
        return remoteRepository.getUserData(userId)
    }

    suspend fun searchUser(searchText: String): Resource<GitHubSearchResponse> {
        return remoteRepository.searchUser(searchText)
    }

    suspend fun getTrendingRepository(timeline: String): Resource<List<TrendingRepositoryItem>> {
        return remoteRepository.getTrendingRepository(timeline)
    }

    suspend fun getTrendingDeveloper(timeline: String): Resource<List<TrendingDeveloperItem>> {
        return remoteRepository.getTrendingDeveloper(timeline)
    }

    suspend fun getUserPinnedProject(userName: String): Resource<List<PinnedUserProjectItem>> {
        return remoteRepository.getUserPinnedProject(userName)
    }
}

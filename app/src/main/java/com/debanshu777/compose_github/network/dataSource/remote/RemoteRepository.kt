package com.debanshu777.compose_github.network.dataSource.remote

import com.debanshu777.compose_github.BuildConfig
import com.debanshu777.compose_github.network.model.GitHubSearchResponse
import com.debanshu777.compose_github.network.model.GitHubUserResponse
import com.debanshu777.compose_github.network.model.PinnedUserProjectItem
import com.debanshu777.compose_github.network.model.TrendingDeveloperItem
import com.debanshu777.compose_github.network.model.TrendingRepositoryItem
import com.debanshu777.compose_github.network.model.userStats.UserStats
import com.debanshu777.compose_github.utils.Constant.GITHUB_BASE_URL
import com.debanshu777.compose_github.utils.Constant.PINNED_PROJECT_URL
import com.debanshu777.compose_github.utils.Constant.RAPID_BASE_API
import com.debanshu777.compose_github.utils.Constant.USER_STATS_URL
import com.debanshu777.compose_github.utils.Resource
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import javax.inject.Inject
import javax.inject.Provider

class RemoteRepository @Inject constructor() {
    @Inject lateinit var httpClient: Provider<HttpClient>
    suspend fun getUserData(userId: String): Resource<GitHubUserResponse> {
        return try {
            Resource.Success(
                data = httpClient.get().use {
                    it.get("${GITHUB_BASE_URL}users/$userId").body()
                }
            )
        } catch (e: Exception) {
            Resource.Error(message = e.message.toString())
        }
    }

    suspend fun searchUser(searchText: String): Resource<GitHubSearchResponse> {
        return try {
            Resource.Success(
                data = httpClient.get().use {
                    it.get("${GITHUB_BASE_URL}search/users") {
                        parameter("q", searchText)
                    }.body()
                }
            )
        } catch (e: Exception) {
            Resource.Error(message = e.message.toString())
        }
    }

    suspend fun getTrendingRepository(timeline: String): Resource<List<TrendingRepositoryItem>> {
        return try {
            Resource.Success(
                data = httpClient.get().use {
                    it.get("${RAPID_BASE_API}repositories") {
                        parameter("since", timeline)
                        headers {
                            append("X-RapidAPI-Host", BuildConfig.RapidAPIHost)
                            append("X-RapidAPI-Key", BuildConfig.RapidAPIKey)
                        }
                    }
                }.body()
            )
        } catch (e: Exception) {
            Resource.Error(message = e.message.toString())
        }
    }

    suspend fun getTrendingDeveloper(timeline: String): Resource<List<TrendingDeveloperItem>> {
        return try {
            Resource.Success(
                data = httpClient.get().use {
                    it.get("${RAPID_BASE_API}developers") {
                        parameter("since", timeline)
                        headers {
                            append("X-RapidAPI-Host", BuildConfig.RapidAPIHost)
                            append("X-RapidAPI-Key", BuildConfig.RapidAPIKey)
                        }
                    }
                }.body()
            )
        } catch (e: Exception) {
            Resource.Error(message = e.message.toString())
        }
    }

    suspend fun getUserPinnedProject(username: String): Resource<List<PinnedUserProjectItem>> {
        return try {
            Resource.Success(
                data = httpClient.get().use {
                    it.get(PINNED_PROJECT_URL) {
                        parameter("username", username)
                    }
                }.body()
            )
        } catch (e: Exception) {
            Resource.Error(message = e.message.toString())
        }
    }

    suspend fun getUserStats(username: String): Resource<UserStats> {
        return try {
            Resource.Success(
                data = httpClient.get().use {
                    it.get("${USER_STATS_URL}${username}")
                }.body()
            )
        } catch (e: Exception) {
            Resource.Error(message = e.message.toString())
        }
    }
}

package com.debanshu777.compose_github.network.dataSource

import com.debanshu777.compose_github.BuildConfig
import com.debanshu777.compose_github.network.model.*
import com.debanshu777.compose_github.utils.Constant.GITHUB_BASE_URL
import com.debanshu777.compose_github.utils.Constant.RAPID_BASE_API
import com.debanshu777.compose_github.utils.Resource
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject
import javax.inject.Provider
import kotlin.io.use

class GitHubRepository @Inject constructor(){
    @Inject lateinit var httpClient : Provider<HttpClient>
    suspend fun getUserData(userId:String): Resource<GitHubUserResponse> {
        return try {
            Resource.Success(data = httpClient.get().use {
                it.get("${GITHUB_BASE_URL}users/${userId}")
            })
        }catch (e:Exception){
            Resource.Error(message = e.message.toString())
        }
    }

    suspend fun searchUser(searchText:String): Resource<GitHubSearchResponse> {
        return try {
            Resource.Success(data = httpClient.get().use {
                it.get("${GITHUB_BASE_URL}search/users"){
                    parameter("q", searchText)
                }
            })
        }catch (e:Exception){
            Resource.Error(message = e.message.toString())
        }
    }

    suspend fun getTrendingRepository(timeline:String): Resource<List<TrendingRepositoryItem>> {
        return try {
            Resource.Success(data = httpClient.get().use {
                it.get("${RAPID_BASE_API}repositories"){
                    parameter("since", timeline)
                    headers{
                        append("X-RapidAPI-Host",BuildConfig.RapidAPIHost)
                        append("X-RapidAPI-Key",BuildConfig.RapidAPIKey)
                    }
                }
            })
        }catch (e:Exception){
            Resource.Error(message = e.message.toString())
        }
    }

    suspend fun getTrendingDeveloper(timeline:String): Resource<List<TrendingDeveloperItem>> {
        return try {
            Resource.Success(data = httpClient.get().use {
                it.get("${RAPID_BASE_API}developers"){
                    parameter("since", timeline)
                    headers{
                        append("X-RapidAPI-Host",BuildConfig.RapidAPIHost)
                        append("X-RapidAPI-Key",BuildConfig.RapidAPIKey)
                    }
                }
            })
        }catch (e:Exception){
            Resource.Error(message = e.message.toString())
        }
    }
}
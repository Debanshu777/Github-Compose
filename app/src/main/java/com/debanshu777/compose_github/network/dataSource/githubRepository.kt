package com.debanshu777.compose_github.network.dataSource

import com.debanshu777.compose_github.network.model.GitHubSearchResponse
import com.debanshu777.compose_github.network.model.GitHubSearchUserList
import com.debanshu777.compose_github.network.model.GitHubUserResponse
import com.debanshu777.compose_github.utils.Constant.BASE_URL
import com.debanshu777.compose_github.utils.Resource
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject
import javax.inject.Provider
import kotlin.io.use

class githubRepository @Inject constructor(){
    @Inject lateinit var httpClient : Provider<HttpClient>
    suspend fun getUserData(userId:String): Resource<GitHubUserResponse> {
        return try {
            Resource.Success(data = httpClient.get().use {
                it.get("${BASE_URL}users/${userId}")
            })
        }catch (e:Exception){
            Resource.Error(message = e.message.toString())
        }
    }

    suspend fun searchUser(searchText:String): Resource<GitHubSearchResponse> {
        return try {
            Resource.Success(data = httpClient.get().use {
                it.get("${BASE_URL}search/users"){
                    parameter("q", searchText)
                }
            })
        }catch (e:Exception){
            Resource.Error(message = e.message.toString())
        }
    }
}
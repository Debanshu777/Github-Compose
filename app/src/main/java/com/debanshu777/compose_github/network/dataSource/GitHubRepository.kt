package com.debanshu777.compose_github.network.dataSource

import com.debanshu777.compose_github.network.model.GitHubUserResponse
import com.debanshu777.compose_github.utils.Resource
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject
import kotlin.io.use

class GitHubRepository @Inject constructor(private val httpClient: HttpClient) {
    suspend fun getUserData(): Resource<GitHubUserResponse> {
        return try {
            Resource.Success(data = httpClient.use {
                it.get("https://api.github.com/users/Debanshu777")
            })
        }catch (e:Exception){
            Resource.Error(message = e.message.toString())
        }
    }
}
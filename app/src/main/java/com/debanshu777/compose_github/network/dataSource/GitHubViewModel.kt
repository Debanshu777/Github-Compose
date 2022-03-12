package com.debanshu777.compose_github.network.dataSource

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.debanshu777.compose_github.network.model.GitHubSearchResponse
import com.debanshu777.compose_github.network.model.GitHubSearchUserList
import com.debanshu777.compose_github.network.model.GitHubUserResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GitHubViewModel @Inject constructor(private val gitHubRepository: GitHubRepository) :ViewModel() {
    val userDataResponseFlow = MutableStateFlow<GitHubUserResponse?>(null)
    val searchUserResponseFlow = MutableStateFlow<GitHubSearchResponse?>(null)
    init {
        getUserData("Debanshu777")
        searchUser("anu")
    }
    fun getUserData(userName:String)=viewModelScope.launch {
            kotlin.runCatching {
                Log.e("Glance","Here")
                gitHubRepository.getUserData(userName)
            }.onSuccess {
                Log.e("Glance",it.data.toString())
                userDataResponseFlow.value=it.data
            }.onFailure {
                userDataResponseFlow.value=null
            }
        }
    fun searchUser(searchText:String)=viewModelScope.launch {
        kotlin.runCatching {
            Log.e("Glance","Here")
            gitHubRepository.searchUser(searchText)
        }.onSuccess {
            Log.e("Glance",it.data.toString())
            searchUserResponseFlow.value=it.data
        }.onFailure {
            searchUserResponseFlow.value=null
        }
    }
}
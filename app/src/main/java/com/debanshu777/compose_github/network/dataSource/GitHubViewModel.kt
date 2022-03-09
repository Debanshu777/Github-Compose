package com.debanshu777.compose_github.network.dataSource

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.debanshu777.compose_github.network.model.GitHubUserResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GitHubViewModel @Inject constructor(private val gitHubRepository: GitHubRepository) :ViewModel() {
    val responseFlow = MutableStateFlow<GitHubUserResponse?>(null)
    init {
        viewModelScope.launch {
            kotlin.runCatching {
                Log.e("Glance","Here")
                gitHubRepository.getUserData()
            }.onSuccess {
                Log.e("Glance",it.data.toString())
                responseFlow.value=it.data
            }.onFailure {
                responseFlow.value=null
            }
        }
    }
}
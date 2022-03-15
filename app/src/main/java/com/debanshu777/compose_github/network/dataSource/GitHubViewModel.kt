package com.debanshu777.compose_github.network.dataSource

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.debanshu777.compose_github.network.model.GitHubSearchResponse
import com.debanshu777.compose_github.network.model.GitHubSearchUserList
import com.debanshu777.compose_github.network.model.GitHubUserResponse
import com.debanshu777.compose_github.ui.feature_profile.state.ProfileState
import com.debanshu777.compose_github.ui.feature_search.state.SearchState
import com.debanshu777.compose_github.ui.feature_search.state.SearchWidgetState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GitHubViewModel @Inject constructor(private val gitHubRepository: GitHubRepository) :ViewModel() {
    val userDataState = MutableStateFlow(ProfileState())
    val searchState= MutableStateFlow(SearchState())

    private val _searchWidgetState:MutableState<SearchWidgetState> =
        mutableStateOf(value = SearchWidgetState.CLOSED)
    val searchWidgetState:State<SearchWidgetState> = _searchWidgetState

    private val _searchTextState:MutableState<String> =
        mutableStateOf(value = "")
    val searchTextState:State<String> = _searchTextState

    fun updateSearchWidgetState(newValue: SearchWidgetState){
        _searchWidgetState.value=newValue
    }

    fun updateSearchTextState(newValue:String){
        _searchTextState.value=newValue
    }

    init {
        getUserData("Debanshu777")
        searchUser("anu")
    }
    fun getUserData(userName:String)=viewModelScope.launch {
            kotlin.runCatching {
                Log.i("GitHubViewModel","in getUserData()")
                userDataState.value=ProfileState(isLoading = true)
                gitHubRepository.getUserData(userName)
            }.onSuccess {
                Log.i("getUserData()",it.data.toString())
                userDataState.value=ProfileState(data=it.data)
            }.onFailure {
                userDataState.value= ProfileState(error=it.message)
            }
        }
    fun searchUser(searchText:String)=viewModelScope.launch {
        kotlin.runCatching {
            Log.i("GitHubViewModel","in searchUser()")
            searchState.value=SearchState(isLoading = true)
            gitHubRepository.searchUser(searchText)
        }.onSuccess {
            Log.i("searchUser()",it.data.toString())
            searchState.value=SearchState(data= it.data?.items)
        }.onFailure {
            searchState.value= SearchState(error=it.message)
        }
    }
}
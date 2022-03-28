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
import com.debanshu777.compose_github.utils.Resource
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

    fun getUserData(userName:String)=viewModelScope.launch {
        when(val result =gitHubRepository.getUserData(userName)){
            is Resource.Loading->{
                userDataState.value=ProfileState(isLoading = true)
            }
            is Resource.Success ->{
                userDataState.value=ProfileState(data= result.data)
            }
            is Resource.Error->{
                searchState.value= SearchState(error=result.message)
            }
        }
        }
    fun searchUser(searchText:String)=viewModelScope.launch {
        when(val result =gitHubRepository.searchUser(searchText)){
            is Resource.Loading->{
                searchState.value=SearchState(isLoading = true)
            }
            is Resource.Success ->{
                searchState.value=SearchState(data= if(result.data ==null) emptyList() else result.data.items)
            }
            is Resource.Error->{
                searchState.value= SearchState(error=result.message)
            }
        }
    }
}
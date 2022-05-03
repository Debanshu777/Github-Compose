package com.debanshu777.compose_github.network.dataSource

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.debanshu777.compose_github.ui.feature_trending.state.DeveloperTrendingState
import com.debanshu777.compose_github.ui.feature_profile.state.ProfileState
import com.debanshu777.compose_github.ui.feature_search.state.SearchState
import com.debanshu777.compose_github.ui.feature_search.state.SearchWidgetState
import com.debanshu777.compose_github.ui.feature_trending.state.RepositoryTrendingState
import com.debanshu777.compose_github.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GitHubViewModel @Inject constructor(private val mainRepository: MainRepository) :ViewModel() {
    val userDataState = MutableStateFlow(ProfileState())
    val trendingRepositoryDataState = MutableStateFlow(RepositoryTrendingState())
    val trendingDeveloperDataState = MutableStateFlow(DeveloperTrendingState())
    val searchState= MutableStateFlow(SearchState())

    init {
        getTrendingRepository("monthly")
        getTrendingDeveloper("monthly")
    }
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
        when(val result =mainRepository.getUserData(userName)){
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
        when(val result =mainRepository.searchUser(searchText)){
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

    fun getTrendingRepository(timeline:String)=viewModelScope.launch {
        when(val result = mainRepository.getTrendingRepository(timeline)){
            is Resource.Loading->{
                trendingRepositoryDataState.value=RepositoryTrendingState(isLoading = true)
            }
            is Resource.Success ->{
                trendingRepositoryDataState.value=RepositoryTrendingState(data= result.data
                    ?: emptyList())
            }
            is Resource.Error->{
                trendingRepositoryDataState.value= RepositoryTrendingState(error=result.message)
            }
        }
    }

    fun getTrendingDeveloper(timeline:String)=viewModelScope.launch {
        when(val result = mainRepository.getTrendingDeveloper(timeline)){
            is Resource.Loading->{
                trendingDeveloperDataState.value= DeveloperTrendingState(isLoading = true)
            }
            is Resource.Success ->{
                trendingDeveloperDataState.value= DeveloperTrendingState(data= result.data
                    ?: emptyList())
            }
            is Resource.Error->{
                trendingDeveloperDataState.value= DeveloperTrendingState(error=result.message)
            }
        }
    }
}
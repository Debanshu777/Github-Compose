package com.debanshu777.compose_github.network.dataSource

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.debanshu777.compose_github.ui.base.state.SearchState
import com.debanshu777.compose_github.ui.base.state.SearchWidgetState
import com.debanshu777.compose_github.ui.feature_profile.state.PinnedProjectState
import com.debanshu777.compose_github.ui.feature_profile.state.ProfileState
import com.debanshu777.compose_github.ui.feature_profile.state.ProfileStatsState
import com.debanshu777.compose_github.ui.feature_trending.state.DeveloperTrendingState
import com.debanshu777.compose_github.ui.feature_trending.state.RepositoryTrendingState
import com.debanshu777.compose_github.utils.DurationType
import com.debanshu777.compose_github.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GitHubViewModel @Inject constructor(private val mainRepository: MainRepository) :
    ViewModel() {
    private val _userDataState = MutableLiveData(ProfileState(isLoading = true))
    val userDataState: LiveData<ProfileState> = _userDataState

    private val _userPinnedImage = MutableLiveData(PinnedProjectState(isLoading = true))
    val userPinnedState: LiveData<PinnedProjectState> = _userPinnedImage

    private val _userStatsState = MutableLiveData(ProfileStatsState(isLoading = true))
    val userStatsState: LiveData<ProfileStatsState> = _userStatsState

    private val _durationType = MutableStateFlow(DurationType.WEEKLY)
    val durationType: LiveData<DurationType> = _durationType.asLiveData()

    private val _durationTypeFilterVisibility = MutableLiveData(false)
    val durationTypeFilterVisibility: LiveData<Boolean> = _durationTypeFilterVisibility

    val trendingRepositoryDataState = MutableStateFlow(RepositoryTrendingState(isLoading = true))
    val trendingDeveloperDataState = MutableStateFlow(DeveloperTrendingState(isLoading = true))
    val developerList = mainRepository.getAllDeveloper()
    val repositoryList = mainRepository.getAllRepository()
    val searchState = MutableStateFlow(SearchState())
    private val _searchWidgetState: MutableState<SearchWidgetState> =
        mutableStateOf(value = SearchWidgetState.CLOSED)
    val searchWidgetState: State<SearchWidgetState> = _searchWidgetState

    private val _searchTextState: MutableState<String> =
        mutableStateOf(value = "")
    val searchTextState: State<String> = _searchTextState

    init {
        getTrendingRepository(_durationType.value.type)
        getTrendingDeveloper(_durationType.value.type)
    }

    fun updateSearchWidgetState(newValue: SearchWidgetState) {
        _searchWidgetState.value = newValue
    }

    fun updateDurationType(type: DurationType) {
        _durationType.value = type
        getTrendingRepository(_durationType.value.type)
        getTrendingDeveloper(_durationType.value.type)
    }

    fun updateDurationTypeFilterVisibility() {
        _durationTypeFilterVisibility.value = !(durationTypeFilterVisibility.value ?: false)
    }

    fun updateSearchTextState(newValue: String) {
        _searchTextState.value = newValue
    }

    fun getUserData(userName: String) = viewModelScope.launch {
        launch { getUserStats(userName) }
        launch { getPinnedProject(userName) }
        when (val result = mainRepository.getUserData(userName)) {
            is Resource.Loading -> {
                _userDataState.value = ProfileState(isLoading = true)
            }
            is Resource.Success -> {
                _userDataState.value = ProfileState(data = result.data)
            }
            is Resource.Error -> {
                _userDataState.value = ProfileState(isLoading = false, error = result.message)
            }
        }
    }

    fun searchUser(searchText: String) = viewModelScope.launch {
        when (val result = mainRepository.searchUser(searchText)) {
            is Resource.Loading -> {
                searchState.value = SearchState(isLoading = true, data = emptyList())
            }
            is Resource.Success -> {
                searchState.value =
                    SearchState(
                        isLoading = false,
                        data = if (result.data == null) emptyList() else result.data.items
                    )
            }
            is Resource.Error -> {
                searchState.value = SearchState(isLoading = false, error = result.message)
            }
        }
    }

    private fun getUserStats(username: String) = viewModelScope.launch {
        when (val result = mainRepository.getUserStats(username)) {
            is Resource.Loading -> {
                _userStatsState.value = ProfileStatsState(isLoading = true)
            }
            is Resource.Success -> {
                _userStatsState.value = ProfileStatsState(data = result.data)
            }
            is Resource.Error -> {
                _userStatsState.value = ProfileStatsState(isLoading = false, error = result.message)
            }
        }
    }

    private fun getPinnedProject(username: String) = viewModelScope.launch {
        when (val result = mainRepository.getUserPinnedProject(username)) {
            is Resource.Loading -> {
                _userPinnedImage.value = PinnedProjectState(isLoading = true, data = emptyList())
            }
            is Resource.Success -> {
                _userPinnedImage.value = PinnedProjectState(isLoading = false, data = result.data)
            }
            is Resource.Error -> {
                _userPinnedImage.value =
                    PinnedProjectState(isLoading = false, error = result.message)
            }
        }
    }

    private fun getTrendingRepository(timeline: String) = viewModelScope.launch {
        when (val result = mainRepository.getTrendingRepository(timeline)) {
            is Resource.Loading -> {
                trendingRepositoryDataState.value =
                    RepositoryTrendingState(isLoading = true, data = emptyList())
            }
            is Resource.Success -> {
                trendingRepositoryDataState.value = RepositoryTrendingState(
                    isLoading = false,
                    data = result.data
                        ?: emptyList()
                )
            }
            is Resource.Error -> {
                trendingRepositoryDataState.value =
                    RepositoryTrendingState(
                        isLoading = false,
                        data = emptyList(),
                        error = result.message
                    )
            }
        }
    }

    private fun getTrendingDeveloper(timeline: String) = viewModelScope.launch {
        when (val result = mainRepository.getTrendingDeveloper(timeline)) {
            is Resource.Loading -> {
                trendingDeveloperDataState.value =
                    DeveloperTrendingState(isLoading = true, data = emptyList())
            }
            is Resource.Success -> {
                trendingDeveloperDataState.value = DeveloperTrendingState(
                    isLoading = false,
                    data = result.data
                        ?: emptyList()
                )
            }
            is Resource.Error -> {
                trendingDeveloperDataState.value =
                    DeveloperTrendingState(isLoading = false, error = result.message)
            }
        }
    }

    fun insertDeveloper(
        id: Long?,
        userName: String,
        name: String,
        avatar: String
    ) = viewModelScope.launch {
        mainRepository.insertDeveloper(
            id, userName, name, avatar
        )
    }

    fun insertRepository(
        id: Long?,
        authorName: String,
        name: String,
        avatar: String,
        description: String,
        language: String,
        languageColor: String,
        forks: Long,
        stars: Long
    ) = viewModelScope.launch {
        mainRepository.insertRepository(
            id, authorName, name, avatar, description, language, languageColor, forks, stars
        )
    }

    fun deleteRepositoryById(id: Long) = viewModelScope.launch {
        mainRepository.deleteRepositoryById(id)
    }

    fun deleteDeveloperById(id: Long) = viewModelScope.launch {
        mainRepository.deleteDeveloperById(id)
    }
}

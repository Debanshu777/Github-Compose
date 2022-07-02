package com.debanshu777.compose_github.ui.feature_profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.debanshu777.compose_github.R
import com.debanshu777.compose_github.network.dataSource.GitHubViewModel
import com.debanshu777.compose_github.ui.feature_profile.components.ProfileDetailsScreen
import com.debanshu777.compose_github.ui.feature_profile.components.UserPinnedProjectSection
import com.debanshu777.compose_github.ui.feature_profile.components.UserStatsSection
import com.debanshu777.compose_github.utils.Loader
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalUnitApi::class)
@Composable
fun ProfileScreen(viewModel: GitHubViewModel = getViewModel()) {
    val profileData by viewModel.userDataState.observeAsState()
    val userPinnedProject by viewModel.userPinnedState.observeAsState()
    val userStats by viewModel.userStatsState.observeAsState()
    Column(
        modifier = Modifier
            .padding(top = 56.dp)
            .verticalScroll(rememberScrollState())
    ) {
        if (profileData!!.error != null || userPinnedProject!!.error != null || userStats!!.error != null) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Loader(R.raw.error_page, Modifier.height(250.dp))
                    Text(
                        modifier = Modifier.padding(vertical = 10.dp),
                        text = "Some Issue From Our Side",
                        fontWeight = FontWeight.W300,
                        fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
                    )
                }
            }
        } else {
            ProfileDetailsScreen(profileData)
            UserStatsSection(userStats!!)
            UserPinnedProjectSection(userPinnedProject!!)
        }
    }
}

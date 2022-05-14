package com.debanshu777.compose_github.ui.feature_profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.debanshu777.compose_github.network.dataSource.GitHubViewModel
import com.debanshu777.compose_github.ui.feature_profile.state.ProfileState

@OptIn(ExperimentalUnitApi::class)
@Composable
fun ProfileScreen(viewModel: GitHubViewModel= hiltViewModel()) {
    val profileData by viewModel.userDataState.observeAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier= Modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
            verticalAlignment=Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AsyncImage(
                modifier = Modifier
                    .height(120.dp)
                    .width(120.dp)
                    .clip(CircleShape),
                model = profileData?.data?.avatarUrl,
                contentScale = ContentScale.Fit,
                contentDescription = "User Avatar"
            )
            Row(
                modifier=Modifier.fillMaxWidth(),
                verticalAlignment=Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Column {
                    Text(
                        text = "Followers",
                        fontSize = TextUnit(value = 18F, type = TextUnitType.Sp),
                    )
                    Text(
                        text = "${profileData?.data?.followers ?: "0"}",
                        fontWeight = FontWeight.Bold,
                        fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
                    )
                }
                Spacer(modifier = Modifier.width(14.dp))
                Column {
                    Text(
                        text = "Following",
                        fontSize = TextUnit(value = 18F, type = TextUnitType.Sp),
                    )
                    Text(
                        text = "${profileData?.data?.following ?: "0"}",
                        fontWeight = FontWeight.Bold,
                        fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
                    )
                }
            }
        }
        Text(
            text = profileData?.data?.name ?: "NA",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = TextUnit(value = 24F, type = TextUnitType.Sp),
        )
        Text(
            text = "@${profileData?.data?.login ?: "NA"}",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontSize = TextUnit(value = 18F, type = TextUnitType.Sp),
        )
        Spacer(modifier = Modifier.height(15.dp))
        profileData?.data?.bio.let {
            Text(
                text = profileData?.data?.bio ?: "",
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        profileData?.data?.company.let {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Company",
                    fontSize = TextUnit(value = 16F, type = TextUnitType.Sp),
                )
                Spacer(modifier = Modifier.width(7.dp))
                Text(
                    text = profileData?.data?.company ?: "NA",
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
                )
            }
        }
        profileData?.data?.location.let {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Location",
                    fontSize = TextUnit(value = 16F, type = TextUnitType.Sp),
                )
                Spacer(modifier = Modifier.width(7.dp))
                Text(
                    text = profileData?.data?.location ?: "NA",
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
                )
            }
        }
        profileData?.data?.email.let {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Email",
                    fontSize = TextUnit(value = 16F, type = TextUnitType.Sp),
                )
                Spacer(modifier = Modifier.width(7.dp))
                Text(
                    text = profileData?.data?.email ?: "NA",
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
                )
            }
        }
        profileData?.data?.blog.let {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Blog",
                    fontSize = TextUnit(value = 16F, type = TextUnitType.Sp),
                )
                Spacer(modifier = Modifier.width(7.dp))
                Text(
                    text = profileData?.data?.blog ?: "NA",
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
                )
            }
        }
        profileData?.data?.twitterUsername.let {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Twitter",
                    fontSize = TextUnit(value = 16F, type = TextUnitType.Sp),
                )
                Spacer(modifier = Modifier.width(7.dp))
                Text(
                    text = "@${profileData?.data?.twitterUsername ?: "NA"}",
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
                )
            }
        }
    }
}

package com.debanshu777.compose_github.ui.feature_profile.components

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
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.Composable
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
import coil.compose.AsyncImage
import com.debanshu777.compose_github.ui.feature_profile.state.ProfileState

@OptIn(ExperimentalUnitApi::class)
@Composable
fun ProfileDetailsScreen(profileData: ProfileState?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
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
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Column {
                    Text(
                        text = "Followers",
                        fontSize = TextUnit(value = 16F, type = TextUnitType.Sp),
                    )
                    Text(
                        text = "${profileData?.data?.followers ?: "0"}",
                        fontWeight = FontWeight.Bold,
                        fontSize = TextUnit(value = 20F, type = TextUnitType.Sp),
                    )
                }
                Spacer(modifier = Modifier.width(14.dp))
                Column {
                    Text(
                        text = "Following",
                        fontSize = TextUnit(value = 16F, type = TextUnitType.Sp),
                    )
                    Text(
                        text = "${profileData?.data?.following ?: "0"}",
                        fontWeight = FontWeight.Bold,
                        fontSize = TextUnit(value = 20F, type = TextUnitType.Sp),
                    )
                }
            }
        }
        Text(
            text = profileData?.data?.name ?: "NA",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.W300,
            fontSize = TextUnit(value = 24F, type = TextUnitType.Sp),
        )
        Text(
            text = "@${profileData?.data?.login ?: "NA"}",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = TextUnit(value = 16F, type = TextUnitType.Sp),
        )
        Spacer(modifier = Modifier.height(5.dp))
        profileData?.data?.bio.let {
            Text(
                text = profileData?.data?.bio ?: "",
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        profileData?.data?.company.let {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Outlined.AccountBox, contentDescription = "Icon Company")
                Spacer(modifier = Modifier.width(7.dp))
                Text(
                    text = profileData?.data?.company ?: "NA",
                    maxLines = 1,
                    fontWeight = FontWeight.W500,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
                )
            }
        }
        profileData?.data?.location.let {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Outlined.LocationOn, contentDescription = "Icon Location")
                Spacer(modifier = Modifier.width(7.dp))
                Text(
                    text = profileData?.data?.location ?: "NA",
                    maxLines = 1,
                    fontWeight = FontWeight.W500,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
                )
            }
        }
        profileData?.data?.email.let {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Outlined.Email, contentDescription = "Icon Company")
                Spacer(modifier = Modifier.width(7.dp))
                Text(
                    text = profileData?.data?.email ?: "NA",
                    maxLines = 1,
                    fontWeight = FontWeight.W500,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
                )
            }
        }
        profileData?.data?.blog.let {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Outlined.Create, contentDescription = "Icon Company")
                Spacer(modifier = Modifier.width(7.dp))
                Text(
                    text = profileData?.data?.blog ?: "NA",
                    maxLines = 1,
                    fontWeight = FontWeight.W500,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
                )
            }
        }
        profileData?.data?.twitterUsername.let {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Outlined.Info, contentDescription = "Icon Company")
                Spacer(modifier = Modifier.width(7.dp))
                Text(
                    text = "@${profileData?.data?.twitterUsername ?: "NA"}",
                    maxLines = 1,
                    fontWeight = FontWeight.W500,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
                )
            }
        }
    }
}
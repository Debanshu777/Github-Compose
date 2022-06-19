package com.debanshu777.compose_github.ui.feature_profile.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.debanshu777.compose_github.R
import com.debanshu777.compose_github.network.model.PinnedUserProjectItem
import com.debanshu777.compose_github.ui.feature_profile.state.PinnedProjectState

@OptIn(ExperimentalUnitApi::class)
@Composable
fun UserPinnedProjectSection(userPinnedProject: PinnedProjectState?) {
    Column(
        modifier = Modifier
            .padding(bottom = 160.dp)
            .padding(horizontal = 15.dp)
    ) {
        Text(
            modifier = Modifier.padding(vertical = 10.dp),
            text = "Pinned Repositories",
            fontWeight = FontWeight.W300,
            fontSize = TextUnit(value = 18F, type = TextUnitType.Sp),
        )
        userPinnedProject?.data?.forEach {
            UserPinnedProjectSectionItem(it)
        }
    }
}

@OptIn(ExperimentalUnitApi::class, ExperimentalMaterial3Api::class)
@Composable
fun UserPinnedProjectSectionItem(pinnedUserProjectItem: PinnedUserProjectItem) {
    ElevatedCard(
        modifier = Modifier
            .height(190.dp)
            .padding(vertical = 5.dp),
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        imageVector = Icons.Outlined.Build,
                        contentDescription = "Build Icon"
                    )
                    Text(
                        modifier = Modifier.padding(7.dp),
                        text = pinnedUserProjectItem.repo ?: "",
                        maxLines = 1,
                        fontWeight = FontWeight.Bold,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = TextUnit(value = 16F, type = TextUnitType.Sp),
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = pinnedUserProjectItem.stars.toString(),
                        fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
                    )
                    Icon(
                        modifier = Modifier
                            .size(25.dp)
                            .padding(3.dp),
                        painter = painterResource(id = R.drawable.ic_star),
                        contentDescription = "Star Icon"
                    )
                    Text(
                        text = pinnedUserProjectItem.forks.toString(),
                        fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
                    )
                    Icon(
                        modifier = Modifier
                            .size(25.dp)
                            .padding(3.dp),
                        painter = painterResource(id = R.drawable.ic_git_icon),
                        contentDescription = "Git Icon"
                    )
                }
            }
            Text(
                modifier = Modifier.padding(2.dp),
                text = pinnedUserProjectItem.description ?: "",
                maxLines = 4,
                overflow = TextOverflow.Ellipsis,
                fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
            )

            Row(
                modifier = Modifier.padding(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Canvas(
                    modifier = Modifier
                        .height(10.dp)
                        .width(10.dp)
                ) {
                    drawCircle(
                        color = pinnedUserProjectItem.languageColor?.toColorInt()?.let { Color(it) }
                            ?: Color.Green,
                        radius = 20f
                    )
                }
                Text(
                    modifier = Modifier.padding(horizontal = 5.dp),
                    text = pinnedUserProjectItem.language ?: "NA",
                    fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
                )
            }

        }
    }
}
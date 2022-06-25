package com.debanshu777.compose_github.ui.feature_trending.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.debanshu777.compose_github.network.dataSource.GitHubViewModel
import com.debanshu777.compose_github.network.model.TrendingDeveloperItem
import com.debanshu777.compose_github.ui.base.Screen
import kotlinx.coroutines.Job
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

@OptIn(ExperimentalUnitApi::class, ExperimentalMaterial3Api::class)
@Composable
fun DeveloperCard(
    item: TrendingDeveloperItem,
    navController: NavController,
    action: (String) -> Job,
    viewModel: GitHubViewModel = hiltViewModel()
) {

    val saveIcon = SwipeAction(
        onSwipe = {
            viewModel.insertDeveloper(
                null,
                item.username ?: "NA",
                item.name ?: "NA",
                item.avatar ?: ""
            )
        },
        icon = {
            Icon(
                modifier = Modifier.padding(16.dp),
                imageVector = Icons.Outlined.Favorite,
                contentDescription = null,
            )
        },
        isUndo = true,
        background = Color(0xDC4CAF50)
    )
    SwipeableActionsBox(
        modifier = Modifier.padding(vertical = 2.5.dp),
        swipeThreshold = 150.dp,
        endActions = listOf(saveIcon)
    ) {
        ElevatedCard(
            modifier = Modifier
                .height(160.dp)
                .align(Alignment.CenterStart),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 5.dp)
                    .clickable {
                        item.username?.let { it1 -> action(it1) }
                        navController.navigate(Screen.ProfileScreen.route)
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    modifier = Modifier
                        .height(70.dp)
                        .width(70.dp)
                        .clip(CircleShape),
                    model = item.avatar,
                    contentScale = ContentScale.Fit,
                    contentDescription = "User Avatar"
                )
                Column(
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    Text(
                        text = item.name ?: "NA",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = TextUnit(value = 20F, type = TextUnitType.Sp),
                    )
                    Text(
                        text = "@${item.username}",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Popular Project",
                        fontWeight = FontWeight.Bold,
                        fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
                    )
                    Text(
                        text = item.repo?.name ?: "NA",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        modifier = Modifier.width(250.dp),
                        text = item.repo?.description ?: "NA",
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = TextUnit(value = 12F, type = TextUnitType.Sp),
                    )
                }
            }
        }
    }
}

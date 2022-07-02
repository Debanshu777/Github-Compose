package com.debanshu777.compose_github.ui.feature_follow.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import composedb.githubDB.DeveloperFollow
import kotlinx.coroutines.Job
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

@OptIn(ExperimentalUnitApi::class, ExperimentalMaterial3Api::class)
@Composable
fun FollowDeveloperCard(
    item: DeveloperFollow,
    navController: NavController,
    action: (String) -> Job,
    cardAction: (Long) -> Job,
    onShowSnackbar: (String) -> Unit
) {
    val deleteItem = SwipeAction(
        onSwipe = {
            cardAction(item.id)
            onShowSnackbar("Removing ${item.username} from following")
        },
        icon = {
            Icon(
                modifier = Modifier.padding(16.dp),
                imageVector = Icons.Outlined.Delete,
                contentDescription = null,
            )
        },
        isUndo = true,
        background = MaterialTheme.colorScheme.errorContainer
    )
    SwipeableActionsBox(
        modifier = Modifier.padding(vertical = 2.5.dp),
        swipeThreshold = 150.dp,
        endActions = listOf(deleteItem),
        backgroundUntilSwipeThreshold = MaterialTheme.colorScheme.surfaceVariant
    ) {
        ElevatedCard(
            modifier = Modifier
                .height(110.dp)
                .align(Alignment.CenterStart)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 5.dp, vertical = 5.dp),
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
                        text = item.name,
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
                }
            }
        }
    }
}
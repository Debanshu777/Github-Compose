package com.debanshu777.compose_github.ui.feature_trending.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.debanshu777.compose_github.network.model.TrendingRepositoryItem

@OptIn(ExperimentalUnitApi::class)
@Composable
fun RepositoryCard(item: TrendingRepositoryItem) {
    Card(
        modifier = Modifier.height(120.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(vertical = 20.dp, horizontal = 5.dp)
                .clickable {
//                                item.login?.let { it1 -> viewModel.getUserData(it1) }
//                                navController.navigate(Screen.ProfileScreen.route)
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Greeting(item.toString())
            AsyncImage(
                modifier = Modifier
                    .height(70.dp)
                    .width(70.dp)
                    .clip(CircleShape),
                model = item.avatar,
                contentScale = ContentScale.Fit,
                contentDescription = "User Avatar"
            )
            Text(
                modifier = Modifier.padding(20.dp),
                text = "@${item.author}",
                fontSize = TextUnit(value = 20F, type = TextUnitType.Sp),
            )
        }
    }
}
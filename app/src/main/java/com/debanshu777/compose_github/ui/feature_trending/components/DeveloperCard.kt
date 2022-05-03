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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.debanshu777.compose_github.network.model.TrendingDeveloperItem

@OptIn(ExperimentalUnitApi::class)
@Composable
fun DeveloperCard(item: TrendingDeveloperItem) {
    Card(
        modifier = Modifier.height(180.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(vertical = 20.dp, horizontal = 5.dp)
                .clickable { },
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
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = item.name ?: "NA",
                    fontSize = TextUnit(value = 20F, type = TextUnitType.Sp),
                )
                Text(
                    text = "@${item.username}",
                    fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Popular Project",
                    fontWeight = FontWeight.Bold,
                    fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
                )
                Text(
                    text = item.repo!!.name ?: "NA",
                    fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = item.repo.description ?: "NA",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = TextUnit(value = 12F, type = TextUnitType.Sp),
                )
            }
        }
    }
}

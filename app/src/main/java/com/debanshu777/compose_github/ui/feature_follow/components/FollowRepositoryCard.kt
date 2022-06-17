package com.debanshu777.compose_github.ui.feature_follow.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import coil.compose.AsyncImage
import com.debanshu777.compose_github.R
import composedb.githubDB.RepositoryFollow

@OptIn(ExperimentalUnitApi::class)
@Composable
fun FollowRepositoryCard(item: RepositoryFollow) {
    Card(
        modifier = Modifier.height(160.dp),
        elevation = 5.dp,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 5.dp, vertical = 5.dp)
                .clickable {
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
                modifier = Modifier.padding(horizontal=8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = item.stars.toString(),
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
                        text = item.forks.toString(),
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
                Text(
                    text = item.name,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = TextUnit(value = 20F, type = TextUnitType.Sp),
                )
                Text(
                    text = "@${item.authorName}",
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = item.description ?: "",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = TextUnit(value = 12F, type = TextUnitType.Sp),
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Canvas(
                            modifier = Modifier
                                .height(10.dp)
                                .width(10.dp)
                        ) {
                            drawCircle(
                                color = item.languageColor?.toColorInt()?.let { Color(it) }
                                    ?: Color.Green,
                                radius = 20f
                            )
                        }
                        Text(
                            modifier = Modifier.padding(horizontal = 5.dp),
                            text = item.language ?: "NA",
                            fontSize = TextUnit(value = 14F, type = TextUnitType.Sp),
                        )
                    }
                }
            }
        }
    }
}
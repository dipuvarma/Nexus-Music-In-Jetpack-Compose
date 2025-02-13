package com.player.music.mp3.presentation.ui.component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PauseCircle
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun MiniPlayerBarComp(
    modifier: Modifier = Modifier,
    image: Int,
    title: String,
    subTitle: String,
    isFavorite: Boolean,
    isPlaying: Boolean,
    onPlayPauseClick: () -> Unit,
    onSurfaceClick: () -> Unit,
    onFavoriteClick: () -> Unit = {},
) {
    val interactionSource = remember { MutableInteractionSource() }
    val infiniteTransition = rememberInfiniteTransition()

    // Animate horizontal scrolling for subtitle
    val translateX by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = -200f, // Adjust based on text width
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 6000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .weight(.4f)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null, // Removes ripple effect
                    onClick = onSurfaceClick
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = image,
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(2.dp))

                // Clipping the scrolling text inside a fixed width box
                Box(
                    modifier = Modifier
                        .fillMaxWidth() // Set max width for scrolling
                        .height(16.dp) // Ensure text doesn't overflow vertically
                        .clip(RectangleShape)
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(start = 4.dp) // Adjust padding if needed
                ) {
                    Text(
                        text = subTitle,
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        modifier = Modifier
                            .offset(x = translateX.dp) // Moves text leftward
                    )
                }
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onPlayPauseClick) {
                Icon(
                    modifier = Modifier.size(57.dp),
                    imageVector = if (isPlaying) Icons.Filled.PauseCircle else Icons.Filled.PlayCircle,
                    contentDescription = "Pause",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            IconButton(onClick = onFavoriteClick) {
                Icon(
                    imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = if (isFavorite) "Unfavorite" else "Favorite",
                    tint = if (isFavorite) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}





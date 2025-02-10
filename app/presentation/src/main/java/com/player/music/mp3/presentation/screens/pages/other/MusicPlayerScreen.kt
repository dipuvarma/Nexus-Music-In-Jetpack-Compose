package com.player.music.mp3.presentation.screens.pages.other

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.IosShare
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.RepeatOne
import androidx.compose.material.icons.filled.SaveAlt
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun MusicPlayerScreen(
    songImage: Int,
    songName: String,
    artistName: String,
    isPlaying: Boolean,
    onPlayPauseClick: () -> Unit,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    onShuffleClick: () -> Unit = {},
    onRepeatClick: () -> Unit = {},
    onFavoriteClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
    onDownloadClick: () -> Unit = {},
) {
    var sliderPosition by remember { mutableFloatStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        AsyncImage(
            modifier = Modifier
                .size(240.dp)
                .shadow(4.dp, CircleShape),
            model = songImage,
            contentDescription = "",
            contentScale = ContentScale.Crop,
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onFavoriteClick) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "",
                    modifier = Modifier.size(28.dp)
                )
            }
            IconButton(onClick = onDownloadClick) {
                Icon(
                    imageVector = Icons.Default.SaveAlt,
                    contentDescription = "",
                    modifier = Modifier.size(28.dp)
                )
            }
            IconButton(onClick = { onShareClick }) {
                Icon(
                    imageVector = Icons.Default.IosShare,
                    contentDescription = "",
                    modifier = Modifier.size(28.dp)
                )
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = songName,
                style = MaterialTheme.typography.headlineMedium.copy(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                ),
                maxLines = 1
            )
            MarqueeText(
                text = artistName,
            )

            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it },
                colors = SliderDefaults.colors(
                    thumbColor = MaterialTheme.colorScheme.primary,
                    activeTrackColor = MaterialTheme.colorScheme.primary,
                    inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer
                )
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onShuffleClick) {
                Icon(
                    imageVector = Icons.Default.Shuffle,
                    contentDescription = "",
                    modifier = Modifier.size(28.dp)
                )
            }
            IconButton(onClick = onPreviousClick) {
                Icon(
                    imageVector = Icons.Default.SkipPrevious,
                    contentDescription = "",
                    modifier = Modifier.size(28.dp)
                )
            }

            Surface(
                modifier = Modifier
                    .size(64.dp), // Increased for better centering
                color = MaterialTheme.colorScheme.primary,
                shape = CircleShape
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(onClick = onPlayPauseClick) {
                        Icon(
                            imageVector = if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                            contentDescription = null,
                            modifier = Modifier.size(36.dp), // Increased size
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
            }

            IconButton(onClick = onNextClick) {
                Icon(
                    imageVector = Icons.Default.SkipNext,
                    contentDescription = "",
                    modifier = Modifier.size(28.dp)
                )
            }
            IconButton(onClick = onRepeatClick) {
                Icon(
                    imageVector = Icons.Default.RepeatOne,
                    contentDescription = "",
                    modifier = Modifier.size(28.dp)
                )
            }
        }
    }
}

@Composable
private fun MarqueeText(
    text: String,
    modifier: Modifier = Modifier,
    speed: Int = 50  // Adjust speed (lower = faster)
) {
    val textWidth = remember { mutableStateOf(0) }
    val parentWidth = remember { mutableStateOf(0) }

    val transition = rememberInfiniteTransition()
    val offsetX by transition.animateFloat(
        initialValue = parentWidth.value.toFloat(), // Start from right
        targetValue = -textWidth.value.toFloat(),  // Move fully left
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = speed * textWidth.value, easing = LinearEasing),
            repeatMode = RepeatMode.Restart, // 🔥 No delay, instantly resets!
        )
    )

    Box(
        modifier = modifier
            .fillMaxWidth() // Width of marquee
            .height(20.dp) // Keep text height consistent
            .clip(RectangleShape)
            .background(MaterialTheme.colorScheme.surface)
            .padding(start = 4.dp)
            .onSizeChanged { size ->
                parentWidth.value = size.width
            }
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall.copy(
                color = MaterialTheme.colorScheme.onSurfaceVariant
            ),
            modifier = Modifier
                .offset(x = offsetX.dp)
                .onSizeChanged { size ->
                    textWidth.value = size.width
                }
        )
    }
}

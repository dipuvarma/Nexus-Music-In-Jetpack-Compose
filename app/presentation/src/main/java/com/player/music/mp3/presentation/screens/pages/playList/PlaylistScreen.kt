package com.player.music.mp3.presentation.screens.pages.playList

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.player.music.mp3.presentation.R
import com.player.music.mp3.presentation.ui.component.MusicBarComp

@Composable
fun PlaylistScreen(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(480.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.placeholder_news),
                contentDescription = null,
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .height(300.dp)
                    .align(Alignment.BottomCenter) // Align to the bottom
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent.copy(alpha = .4f),
                                Color.Black.copy(alpha = .7f),
                                Color.Black
                            ),
                            startY = 0f,
                            endY = 1300f
                        )
                    )
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    modifier = Modifier
                        .size(180.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.placeholder_news),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Spacer(Modifier.height(50.dp))
            MiddleDetailsText(
                artistName = "Dipu",
                songName = "Song Name",
                listenerCount = "1000000 times listen",
                onFollowClick = {},
                onMoreClick = {}
            )
            Spacer(Modifier.height(16.dp))
            LazyColumn {
                items(10){
                    MusicBarComp(
                        modifier = Modifier.padding(8.dp),
                        image = R.drawable.placeholder_news,
                        title = "Song Name",
                        subTitle = "Artist Name",
                        isPlaying = true,
                        isFavorite = false,
                    )
                }
            }
        }
    }
}


@Composable
fun MiddleDetailsText(
    modifier: Modifier = Modifier,
    artistName: String,
    songName: String,
    listenerCount: String,
    onFollowClick: () -> Unit,
    onMoreClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp), // Add padding around the row
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp) // Adjust spacing between elements in the column
        ) {
            Text(
                text = artistName,
                style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary // Use primary color for title
                )
            )

            Text(
                text = songName,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground // Use onBackground color for emphasis
                )
            )

            Text(
                text = listenerCount,
                style = MaterialTheme.typography.titleSmall.copy(
                    color = MaterialTheme.colorScheme.secondary // Use secondary color for subtitle
                )
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp) // Add spacing between button and icon
            ) {
                OutlinedButton(
                    onClick = {},
                    shape = RoundedCornerShape(8.dp), // Slightly rounded corners for better visuals
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text(text = "Following")
                }
                Image(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More Options",
                    modifier = Modifier
                        .size(32.dp) // Adjust icon size
                        .clickable {
                            onMoreClick.invoke()
                        },
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
                )
            }
        }

        Box(
            modifier = Modifier
                .size(64.dp) // Increase the size for better visibility
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer), // Use primary container for background
            contentAlignment = Alignment.Center
        ) {
            IconButton(onClick = {
                onFollowClick.invoke()
            }) {
                Icon(
                    modifier = Modifier.size(48.dp), // Maintain consistent icon size
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Play",
                    tint = MaterialTheme.colorScheme.onPrimaryContainer // Match icon color with the background
                )
            }
        }
    }
}


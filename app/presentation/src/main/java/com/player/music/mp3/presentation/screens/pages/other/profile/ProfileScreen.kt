package com.player.music.mp3.presentation.screens.pages.other.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Interests
import androidx.compose.material.icons.filled.PlaylistAdd
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.player.music.mp3.presentation.R
import com.player.music.mp3.presentation.ui.component.ProfileListComp
import com.player.music.mp3.presentation.ui.theme.NexusMusicTheme

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
                        MaterialTheme.colorScheme.background
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Surface(
                modifier = Modifier
                    .size(120.dp)
                    .shadow(elevation = 10.dp, shape = CircleShape),
                shape = CircleShape,
                color = MaterialTheme.colorScheme.surface
            ) {
                Image(
                    painter = painterResource(R.drawable.placeholder_news),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Dipu Verma",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp
                ),
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "It is a long established fact that a reader will be distracted by the readable content.",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 22.sp
                ),
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                maxLines = 3
            )
        }

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 300.dp)
                .align(Alignment.BottomCenter),
            color = MaterialTheme.colorScheme.background,
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                ProfileListComp(
                    icon = Icons.Default.PlaylistAdd,
                    title = "Create Playlist",
                    subTitle = "Create a new playlist"
                )
                ProfileListComp(
                    icon = Icons.Default.Bookmark,
                    title = "Bookmark Songs",
                    subTitle = "Bookmark songs you love"
                )
                ProfileListComp(
                    icon = Icons.Default.Favorite,
                    title = "Favorite",
                    subTitle = "View your favorite songs"
                )
                ProfileListComp(
                    icon = Icons.Default.DarkMode,
                    title = "Theme",
                    subTitle = "Change your theme"
                )
                ProfileListComp(
                    icon = Icons.Default.Interests,
                    title = "Manage Interest",
                    subTitle = "Change your song"
                )
                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Logout")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Divider(
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
                    thickness = 1.dp
                )
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Text(
                        text = "App Version 1.0.0",
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
                        )
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun PreComp() {
    NexusMusicTheme {
        Surface {
            ProfileScreen()
        }
    }
}
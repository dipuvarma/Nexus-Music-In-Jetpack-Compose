package com.player.music.mp3.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.player.music.mp3.presentation.R
import com.player.music.mp3.presentation.ui.theme.NexusMusicTheme
import com.player.music.mp3.presentation.ui.theme.onPrimaryLight
import com.player.music.mp3.presentation.ui.theme.primaryLight


@Composable
fun SongCategoryCardComp(
    modifier: Modifier = Modifier,
    songImage: Int,
    categoryName: String,
    firstColor: Color,
    secondColor: Color,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(16f / 9f)
            .clip(RoundedCornerShape(20.dp)) // Smooth rounded corners
            .clickable(onClick = onClick)
            .shadow(8.dp, RoundedCornerShape(20.dp)) // Subtle shadow for depth
    ) {
        Box {

            Image(
                painter = painterResource(id = songImage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.linearGradient(
                        colors = listOf(firstColor.copy(alpha = .5f), secondColor.copy(alpha = .5f))
                    )
                )
        )

        Image(
            painter = painterResource(id = R.drawable.pattern_bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(alpha = 0.3f)
        )
        TextWithSlideComp(
            categoryName = categoryName
        )
    }
}



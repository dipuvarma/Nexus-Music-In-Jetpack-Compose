package com.player.music.mp3.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.player.music.mp3.presentation.R
import com.player.music.mp3.presentation.ui.theme.NexusMusicTheme

@Composable
fun SliderComp(
    modifier: Modifier = Modifier,
    image:Int,
    title:String,
    description:String
) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(id =image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            maxLines = 2
        )
        Text(
            text = description,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Light,
            maxLines = 3
        )
    }
}


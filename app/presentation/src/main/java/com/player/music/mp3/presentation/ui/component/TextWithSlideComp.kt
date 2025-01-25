package com.player.music.mp3.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TextWithSlideComp(
    modifier: Modifier = Modifier,
    categoryName: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom, // Align content at the bottom
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = categoryName,
            style = MaterialTheme.typography.bodyLarge
                .copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                ),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Decorative bar under the text
        Box(
            modifier = Modifier
                .width(80.dp)
                .height(6.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color.White, Color.Gray)
                    ),
                    shape = RoundedCornerShape(3.dp)
                )
        )
    }
}






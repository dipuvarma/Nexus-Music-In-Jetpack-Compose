package com.player.music.mp3.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import com.player.music.mp3.presentation.ui.component.LogoWithTextComp
import com.player.music.mp3.presentation.R
import com.player.music.mp3.presentation.ui.theme.NexusMusicTheme

@Composable
fun SplashScreenUI(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        LogoWithTextComp(
            image = R.drawable.nexus_app_logo,
            text = "Nexus Music"
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewComp() {
    NexusMusicTheme() {
        Surface {
            SplashScreenUI()
        }
    }
}
package com.player.music.mp3.presentation.screens.pages.starter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.player.music.mp3.presentation.ui.component.LogoWithTextComp
import com.player.music.mp3.presentation.R

@Composable
fun SplashScreen() {

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        LogoWithTextComp(
            image = R.drawable.nexus_app_logo,
            text = context.getString(R.string.app_name)
        )
    }
}



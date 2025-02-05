package com.player.music.mp3.musicplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import com.player.music.mp3.presentation.ui.nav.NexusMusicApp
import com.player.music.mp3.presentation.ui.theme.NexusMusicTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NexusMusicTheme(dynamicColor = false) {
                Surface() {
                    NexusMusicApp()
                }
            }
        }
    }
}



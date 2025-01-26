package com.player.music.mp3.musicplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.player.music.mp3.presentation.ui.component.SongCategoryCardComp
import com.player.music.mp3.presentation.ui.component.TextWithSlideComp
import com.player.music.mp3.presentation.ui.screens.PlaylistScreenUI
import com.player.music.mp3.presentation.ui.theme.NexusMusicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NexusMusicTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding)) {
                        PlaylistScreenUI()
                    }
                }
            }
        }
    }
}


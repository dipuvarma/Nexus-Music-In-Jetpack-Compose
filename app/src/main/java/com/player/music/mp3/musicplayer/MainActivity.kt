package com.player.music.mp3.musicplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.player.music.mp3.presentation.R
import com.player.music.mp3.presentation.ui.component.PopularSongComp
import com.player.music.mp3.presentation.ui.theme.NexusMusicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NexusMusicTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding)) {
                        LazyColumn(){
                            items(10){
                                PopularSongComp(
                                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                                    songImage = R.drawable.placeholder_news,
                                    songName = "Song Name",
                                    artistName = "Artist Name",
                                    icon = Icons.Default.Add,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


package com.player.music.mp3.presentation.screens.pages.other

import android.content.Context
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.player.core.database.table.OfflineAudioTable
import com.player.music.mp3.presentation.screens.state.MusicVM

@Composable
fun MusicPlayerScreen(
    context: Context,
    musicVM: MusicVM
) {

    val songList = musicVM.songListState.collectAsState().value

    val player = ExoPlayer.Builder(context).build()

    MusicBarList(
        songList = songList,
        onClick = {
            player.setMediaItem(MediaItem.fromUri(it))
            player.prepare()
            player.play()
        }
    )
}

@Composable
fun MusicBarList(
    songList: List<OfflineAudioTable>,
    onClick: (String) -> Unit
) {
    val state = rememberLazyListState()
    LazyColumn(state = state) {
        items(songList, key = { it.id }) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                onClick = { onClick(it.path) }
            ) {
                Text(text = it.name, modifier = Modifier.padding(16.dp))
            }
            HorizontalDivider()
        }
    }
}
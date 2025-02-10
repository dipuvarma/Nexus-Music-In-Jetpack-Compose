package com.player.music.mp3.presentation.screens.pages.other

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.player.core.database.table.OfflineAudioTable
import com.player.music.mp3.presentation.screens.state.MusicVM

@Composable
fun AllSongScreen(
    musicVM: MusicVM
) {
    val songList = musicVM.songListState.collectAsState().value

    MusicBarList(
        songList = songList,
        onClick = {clickedSongPath->
            val startIndex = songList.indexOfFirst { it.path == clickedSongPath }
            if (startIndex != -1) {
                musicVM.startPlaylistSong(songList.map { it.path }, startIndex)
            }
        }
    )
}

@Composable
private fun MusicBarList(
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
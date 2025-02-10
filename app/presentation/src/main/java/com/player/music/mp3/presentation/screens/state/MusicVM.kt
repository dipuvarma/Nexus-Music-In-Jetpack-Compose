package com.player.music.mp3.presentation.screens.state

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.player.core.database.table.OfflineAudioTable
import com.player.data.repo.impl.OfflineMusicRepoImpl
import com.player.data.utils.response.doOnFailure
import com.player.data.utils.response.doOnLoading
import com.player.data.utils.response.doOnSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class MusicVM @Inject constructor(
    private val repo: OfflineMusicRepoImpl,
    private val player: ExoPlayer
) : ViewModel() {

    private val _songListState = MutableStateFlow<List<OfflineAudioTable>>(emptyList())
    val songListState = _songListState.asStateFlow()


    /*Exo Player*/
    private var _isPlaying = MutableStateFlow(false)
    val isPlayingState = _isPlaying.asStateFlow()

    fun playSong() = player.play()
    fun pauseSong() = player.pause()
    fun nextSong() = player.seekToNext()
    fun previousSong() = player.seekToPrevious()


    fun startPlaylistSong(songUris: List<String>, startIndex: Int) {
        viewModelScope.launch {
            val mediaItems = songUris.map { MediaItem.fromUri(it) }
            player.apply {
                setMediaItems(mediaItems, startIndex, 0L) // Start from the clicked song
                prepare()
            }
        }
    }



    init {
        player.addListener(object : Player.Listener {
            override fun onPlaybackStateChanged(playbackState: Int) {
                super.onPlaybackStateChanged(playbackState)
                when (playbackState) {
                    Player.STATE_BUFFERING -> {
                        Log.e("onPlaybackStateChanged", "State_Buffering")
                    }

                    Player.STATE_READY -> {
                        player.play()
                        _isPlaying.value = true
                    }

                    Player.STATE_ENDED -> {
                        player.seekToNext()
                        Log.e("onPlaybackStateChanged", "State_Ended")

                    }

                    Player.STATE_IDLE -> {
                        Log.e("onPlaybackStateChanged", "Idle_State")

                    }
                }
            }

            override fun onIsPlayingChanged(isPlaying: Boolean) {
                super.onIsPlayingChanged(isPlaying)
                _isPlaying.value = isPlaying
            }
        })
        getMusic()
    }

    fun getMusic() {
        viewModelScope.launch {
            repo.getOfflineMusic().doOnSuccess {
                it?.let { songList ->
                    _songListState.value = songList
                }

            }.doOnFailure { throwable, songList ->
                songList?.let {
                    _songListState.value = songList
                }

            }.doOnLoading { songList ->
                songList?.let {
                    _songListState.value = songList
                }
            }.collect()
        }
    }
}
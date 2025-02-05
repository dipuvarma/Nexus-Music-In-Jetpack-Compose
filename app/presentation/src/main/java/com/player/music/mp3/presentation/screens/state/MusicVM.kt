package com.player.music.mp3.presentation.screens.state

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.player.core.database.table.OfflineAudioTable
import com.player.data.repo.impl.OfflineMusicRepoImpl
import com.player.data.utils.response.doOnFailure
import com.player.data.utils.response.doOnLoading
import com.player.data.utils.response.doOnSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MusicVM @Inject constructor(
    private val repo: OfflineMusicRepoImpl
) : ViewModel() {


    private val _songListState = MutableStateFlow<List<OfflineAudioTable>>(emptyList())
    val songListState = _songListState.asStateFlow()

    init {
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
//                    Log.e("getMusic", " Error ${songList.size}")
                }
//
            }.doOnLoading { songList ->
                songList?.let {
                    _songListState.value = songList
//                    Log.e("getMusic", " Loading ${songList.size}")
                }
            }.collect()
        }
    }
}
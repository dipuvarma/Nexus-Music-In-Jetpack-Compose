package com.player.music.mp3.presentation.screens.state.model

data class MusicCategory(
    val name: String,
    val image: Int,
    var isSelected: Boolean = false
)
package com.player.music.mp3.presentation.ui.component.bottom

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomItem<T : Any>(
    val name: String,
    val route: T,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector
)

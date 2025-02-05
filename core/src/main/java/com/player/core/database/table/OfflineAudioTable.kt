package com.player.core.database.table

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "offline_audio_table")
data class OfflineAudioTable(
    @PrimaryKey(autoGenerate = false)
    val id: Long = 0,
    val path: String = "",
    val name: String = ""
)

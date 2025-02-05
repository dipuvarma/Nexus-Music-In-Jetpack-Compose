package com.player.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.player.core.database.table.OfflineAudioTable
import kotlinx.coroutines.flow.Flow

@Dao
interface OfflineMusicDao {

    @Query("SELECT * FROM offline_audio_table")
    fun getAllOfflineAudio(): Flow<List<OfflineAudioTable>>

    @Upsert
    suspend fun upsertOfflineAudio(offlineAudioTable: List<OfflineAudioTable>)

}
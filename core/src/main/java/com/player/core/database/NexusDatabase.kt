package com.player.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.player.core.database.dao.OfflineMusicDao
import com.player.core.database.table.OfflineAudioTable

@Database(entities = [OfflineAudioTable::class], version = 1, exportSchema = false)
abstract class NexusDatabase : RoomDatabase() {
    abstract fun getOfflineMusicDao() : OfflineMusicDao

}
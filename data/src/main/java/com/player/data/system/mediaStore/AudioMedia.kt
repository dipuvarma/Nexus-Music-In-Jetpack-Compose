package com.player.data.system.mediaStore

import android.content.ContentResolver
import android.provider.MediaStore
import android.provider.MediaStore.Audio.Media
import com.player.core.database.table.OfflineAudioTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AudioMedia @Inject constructor(
    private val contentResolver: ContentResolver
) {

    suspend fun getAudio(): MutableList<OfflineAudioTable> {

        val songList = mutableListOf<OfflineAudioTable>()

        withContext(Dispatchers.IO) {
            val projection = arrayOf(
                Media._ID,
                Media.TITLE,
                Media.DATA
            )
            contentResolver.query(
                MediaStore.Files.getContentUri("external"),
                projection,
                null,
                null,
                null
            )?.use { cursor ->
                val idColumn = cursor.getColumnIndexOrThrow(Media._ID)
                val titleColumn = cursor.getColumnIndexOrThrow(Media.TITLE)
                val dataColumn = cursor.getColumnIndexOrThrow(Media.DATA)

                while (cursor.moveToNext()) {
                    val id = cursor.getLong(idColumn)
                    val title = cursor.getString(titleColumn)
                    val data = cursor.getString(dataColumn)

                    val song = OfflineAudioTable(id, data, title)
                    songList.add(song)
                }
            }
        }
        return songList
    }
}
package com.player.data.repo.impl

import com.player.core.database.dao.OfflineMusicDao
import com.player.core.database.table.OfflineAudioTable
import com.player.data.repo.OfflineMusicRepo
import com.player.data.system.mediaStore.AudioMedia
import com.player.data.utils.response.Resource
import com.player.data.utils.response.mediaBoundResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OfflineMusicRepoImpl @Inject constructor(
    private val dao: OfflineMusicDao,
    private val audioMedia: AudioMedia
) : OfflineMusicRepo {

    override fun getOfflineMusic(): Flow<Resource<List<OfflineAudioTable>>> {

        return mediaBoundResource(
            query = { dao.getAllOfflineAudio() },
            fetch = {audioMedia.getAudio()},
            saveFetchResult = {
                dao.upsertOfflineAudio(it)
            }
        )
    }

}
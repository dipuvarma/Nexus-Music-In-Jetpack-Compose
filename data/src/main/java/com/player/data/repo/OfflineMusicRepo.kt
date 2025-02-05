package com.player.data.repo

import com.player.core.database.table.OfflineAudioTable
import com.player.data.utils.response.Resource
import kotlinx.coroutines.flow.Flow

interface OfflineMusicRepo {

      fun getOfflineMusic(): Flow<Resource<List<OfflineAudioTable>>>
}
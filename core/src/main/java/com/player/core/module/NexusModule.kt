package com.player.core.module

import android.content.Context
import androidx.room.Room
import com.player.core.database.NexusDatabase
import com.player.core.utils.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NexusModule {


    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NexusDatabase {
        return Room.databaseBuilder(context, NexusDatabase::class.java, DB_NAME)
            .build()
    }

    @Provides
    @Singleton
    fun provideOfflineMusicDao(nexusDatabase: NexusDatabase) = nexusDatabase.getOfflineMusicDao()

}
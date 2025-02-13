package com.player.music.mp3.presentation.exoplayer

import android.content.Context
import androidx.media3.exoplayer.ExoPlayer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ExoPlayerInstance {

    @Provides
    @Singleton
    fun provideExoPlayer(@ApplicationContext context: Context) = ExoPlayer.Builder(context).build()
}
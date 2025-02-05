package com.player.data.di

import com.player.data.repo.OfflineMusicRepo
import com.player.data.repo.impl.OfflineMusicRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ProvideRepo {

    @Binds
    abstract fun provideRepo(offlineMusicRepoImpl: OfflineMusicRepoImpl): OfflineMusicRepo

}
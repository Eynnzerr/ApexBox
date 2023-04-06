package com.eynnzerr.apexbox.data.module

import com.eynnzerr.apexbox.base.CPApplication
import com.eynnzerr.apexbox.data.source.local.NewsDao
import com.eynnzerr.apexbox.data.source.local.NewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomDaoModule {
    @Provides
    @Singleton
    fun provideNewsDao(): NewsDao = NewsDatabase.getInstance(CPApplication.context).getDao()
}
package com.eynnzerr.apexbox.data.module

import com.eynnzerr.apexbox.data.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideAppNetworkDataSource(): RemoteDataSource = RemoteDataSource.instance
}
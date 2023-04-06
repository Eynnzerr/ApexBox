package com.eynnzerr.apexbox.data.repository

import com.eynnzerr.apexbox.data.model.bean.ApexNews
import com.eynnzerr.apexbox.data.preference.MMKVAgent
import com.eynnzerr.apexbox.data.preference.PreferenceKeys
import com.eynnzerr.apexbox.data.source.local.NewsDao
import com.eynnzerr.apexbox.data.source.remote.RemoteDataSource
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: NewsDao
) {
    private val apiKey = MMKVAgent.decodeString(PreferenceKeys.API_KEY)

    suspend fun getMapRotation() = remoteDataSource.getMapRotation(apiKey)

    suspend fun getNews() = remoteDataSource.getNews(apiKey)

    // TODO 如果是新的一天，则重新向网络获取制造器列表，否则直接从本地缓存的数据库中读取数据
    suspend fun getCraftList() = remoteDataSource.getCraftList(apiKey)

    fun getCachedNewsFlow() = localDataSource.getCachedNews()

    suspend fun insertNews(vararg news: ApexNews) = localDataSource.insertNews(*news)
}
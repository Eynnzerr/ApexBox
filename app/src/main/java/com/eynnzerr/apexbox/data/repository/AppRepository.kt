package com.eynnzerr.apexbox.data.repository

import com.eynnzerr.apexbox.data.preference.MMKVAgent
import com.eynnzerr.apexbox.data.preference.PreferenceKeys
import com.eynnzerr.apexbox.data.source.RemoteDataSource
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) {
    private val apiKey = MMKVAgent.decodeString(PreferenceKeys.API_KEY)

    suspend fun getMapRotation() = remoteDataSource.getMapRotation(apiKey)
}
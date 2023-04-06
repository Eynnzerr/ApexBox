package com.eynnzerr.apexbox.data.source.remote

import com.eynnzerr.apexbox.data.model.bean.ApexNews
import com.eynnzerr.apexbox.data.model.bean.CraftItem
import com.eynnzerr.apexbox.data.model.bean.MapRotation
import com.eynnzerr.apexbox.data.model.bean.PlayerStats
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteDataSource {

    @GET(Api.MAP_ROTATION)
    suspend fun getMapRotation(@Query("auth") key: String, @Query("version") version: Int = 2): Response<MapRotation>

    @GET(Api.CRAFT_LIST)
    suspend fun getCraftList(@Query("auth") key: String): Response<List<CraftItem>>

    @GET(Api.NEWS)
    suspend fun getNews(@Query("auth") key: String): Response<List<ApexNews>>

    @GET(Api.PLAYER_STATS)
    suspend fun getPlayerStats(
        @Query("auth") key: String,
        @Query("player") player: String,
        @Query("platform") platform: String
    ): Response<PlayerStats>

    companion object {
        val instance: RemoteDataSource by lazy {
            Retrofit.Builder()
                .baseUrl("https://api.mozambiquehe.re")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RemoteDataSource::class.java)
        }
    }

}
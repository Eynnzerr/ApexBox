package com.eynnzerr.apexbox.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eynnzerr.apexbox.data.model.bean.ApexNews
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Query("SELECT * FROM apex_news")
    fun getCachedNews(): Flow<List<ApexNews>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNews(vararg news: ApexNews)
}
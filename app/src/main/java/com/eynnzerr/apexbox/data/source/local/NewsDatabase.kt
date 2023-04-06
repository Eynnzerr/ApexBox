package com.eynnzerr.apexbox.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.eynnzerr.apexbox.data.model.bean.ApexNews

@Database(
    version = 1,
    entities = [ApexNews::class],
)
abstract class NewsDatabase: RoomDatabase() {
    abstract fun getDao(): NewsDao

    companion object {
        private const val databaseName = "eynnzerr-apexbox"
        private var INSTANCE: NewsDatabase? = null

        @Synchronized
        fun getInstance(context: Context): NewsDatabase {
            return INSTANCE?: Room.databaseBuilder(context.applicationContext, NewsDatabase::class.java, databaseName)
                .build()
        }
    }
}
package com.eynnzerr.apexbox.data.model.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "apex_news")
data class ApexNews(
    @PrimaryKey(autoGenerate = false)
    val link: String = "",
    @ColumnInfo(defaultValue = "")
    val img: String = "",
    @ColumnInfo(defaultValue = "")
    val short_desc: String = "",
    @ColumnInfo(defaultValue = "")
    val title: String = ""
)

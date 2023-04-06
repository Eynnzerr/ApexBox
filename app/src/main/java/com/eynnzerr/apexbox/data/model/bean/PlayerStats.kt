package com.eynnzerr.apexbox.data.model.bean

import com.google.gson.annotations.SerializedName

data class PlayerStats(
    @SerializedName("global")
    val global: Global = Global(),
    @SerializedName("legends")
    val legends: Legends = Legends(),
    @SerializedName("realtime")
    val realtime: Realtime = Realtime()
)

data class Global(
    @SerializedName("level")
    val level: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("toNextLevelPercent")
    val toNextLevelPercent: Int = 0,
    @SerializedName("uid")
    val uid: Long = 0,
    @SerializedName("rank")
    val rank: Rank = Rank()
)

data class Legends(
    @SerializedName("selected")
    val selected: Selected = Selected()
)

data class Realtime(
    @SerializedName("currentStateAsText")
    val currentStateAsText: String = "",
    @SerializedName("selectedLegend")
    val selectedLegend: String = ""
)

data class Selected(
    @SerializedName("ImgAssets")
    val imgAssets: ImgAssets = ImgAssets(),
    @SerializedName("LegendName")
    val legendName: String = "",
)

data class ImgAssets(
    @SerializedName("banner")
    val bannerUrl: String = "",
    @SerializedName("icon")
    val iconUrl: String = ""
)

data class Rank(
    val ladderPosPlatform: Int = 0,
    val rankDiv: Int = 0,
    val rankImg: String = "",
    val rankName: String = "",
    val rankScore: Int = 0,
    val rankedSeason: String = ""
)
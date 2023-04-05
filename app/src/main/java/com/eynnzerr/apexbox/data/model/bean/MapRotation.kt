package com.eynnzerr.apexbox.data.model.bean

data class MapRotation(
    val arenas: Arenas = Arenas(),  // 竞技场 当前版本弃用
    val arenasRanked: ArenasRanked = ArenasRanked(),  // 排位竞技场 当前版本弃用
    val battle_royale: BattleRoyale = BattleRoyale(),  // 大逃杀
    val ltm: Ltm = Ltm(),  // 混录带模式
    val ranked: Ranked = Ranked()  // 大逃杀排位
)

data class Arenas(
    val current: BRCurrentInfo = BRCurrentInfo(),
    val next: BRNextInfo = BRNextInfo()
)

data class ArenasRanked(
    val current: BRCurrentInfo = BRCurrentInfo(),
    val next: BRNextInfo = BRNextInfo()
)

data class BattleRoyale(
    val current: BRCurrentInfo = BRCurrentInfo(),
    val next: BRNextInfo = BRNextInfo()
)

data class Ltm(
    val current: MixtapeCurrentInfo = MixtapeCurrentInfo(),
    val next: MixtapeNextInfo = MixtapeNextInfo()
)

data class Ranked(
    val current: BRCurrentInfo = BRCurrentInfo(),
    val next: BRNextInfo = BRNextInfo()
)

data class BRCurrentInfo(
    val DurationInMinutes: Int = 0,
    val DurationInSecs: Int = 0,
    val asset: String = "",
    val code: String = "",
    val end: Int = 0,
    val map: String = "--",
    val readableDate_end: String = "00:00:00",
    val readableDate_start: String = "00:00:00",
    val start: Int = 0,
    val remainingMins: Int = 0,
    val remainingSecs: Int = 0,
    val remainingTimer: String = "00:00:00",
)

data class BRNextInfo(
    val DurationInMinutes: Int = 0,
    val DurationInSecs: Int = 0,
    val asset: String = "",
    val code: String = "",
    val end: Int = 0,
    val map: String = "--",
    val readableDate_end: String = "00:00:00",
    val readableDate_start: String = "00:00:00",
    val start: Int = 0
)

data class MixtapeCurrentInfo(
    val DurationInMinutes: Int = 0,
    val DurationInSecs: Int = 0,
    val asset: String = "",
    val code: String = "",
    val end: Int = 0,
    val eventName: String = "--",
    val isActive: Boolean = false,
    val map: String = "--",
    val readableDate_end: String = "00:00:00",
    val readableDate_start: String = "00:00:00",
    val start: Int = 0,
    val remainingMins: Int = 0,
    val remainingSecs: Int = 0,
    val remainingTimer: String = "00:00:00",
)

data class MixtapeNextInfo(
    val DurationInMinutes: Int = 0,
    val DurationInSecs: Int = 0,
    val asset: String = "",
    val code: String = "",
    val end: Int = 0,
    val eventName: String = "--",
    val isActive: Boolean = false,
    val map: String = "--",
    val readableDate_end: String = "00:00:00",
    val readableDate_start: String = "00:00:00",
    val start: Int = 0
)
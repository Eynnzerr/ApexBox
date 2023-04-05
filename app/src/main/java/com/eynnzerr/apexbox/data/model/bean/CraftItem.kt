package com.eynnzerr.apexbox.data.model.bean

data class CraftItem(
    val bundle: String, // 制造系列名称
    val bundleContent: List<BundleContent>, // 系列物品详细信息
    val bundleType: String, // 制造系列类型（每日、每周、赛季、永久）
    val end: Int, // 截止时间戳
    val endDate: String, // 截止日期（有用）
    val start: Int, // 开始时间戳
    val startDate: String // 开始日期（有用）
)

data class BundleContent(
    val cost: Int, // 造价
    val item: String, // 名称
    val itemType: ItemType // 更多信息
)

data class ItemType(
    val asset: String, // 图片资源路径
    val name: String, // 名称
    val rarity: String, // 稀有度
    val rarityHex: String // 代表稀有度的颜色16进制
)
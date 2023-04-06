package com.eynnzerr.apexbox.data.model.bean

data class CraftItem(
    val bundle: String = "", // 制造系列名称
    val bundleContent: List<BundleContent> = emptyList(), // 系列物品详细信息
    val bundleType: String = "", // 制造系列类型（每日、每周、永久）
    val end: Int = 0, // 截止时间戳
    val endDate: String = "", // 截止日期
    val start: Int = 0, // 开始时间戳
    val startDate: String = "" // 开始日期
) {
    companion object {
        const val TYPE_DAILY = "daily"
        const val TYPE_WEEKLY = "weekly"
        const val TYPE_PERMANENTLY = "permanent"
    }
}

data class BundleContent(
    val cost: Int = 0, // 造价
    val item: String = "--", // 名称
    val itemType: ItemType = ItemType() // 更多信息
)

data class ItemType(
    val asset: String = "https://legion.apexlegendsstatus.com/cache/4445aea4337022d3694f5d3b07940a6b.png", // 图片资源路径
    val name: String = "--", // 名称
    val rarity: String = "", // 稀有度
    val rarityHex: String = "#808080" // 代表稀有度的颜色16进制
)
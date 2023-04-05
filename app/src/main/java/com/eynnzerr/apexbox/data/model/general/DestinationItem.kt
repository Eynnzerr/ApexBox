package com.eynnzerr.apexbox.data.model.general

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Feed
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Feed
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.eynnzerr.apexbox.R
import com.eynnzerr.apexbox.ui.navigation.Destinations

sealed class DestinationItem(
    val index: Int,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: String
) {
    @Composable
    fun toLabel() = when (this) {
        is Home -> stringResource(id = R.string.item_home)
        is News -> stringResource(id = R.string.item_news)
        is Settings -> stringResource(id = R.string.item_settings)
    }

    object Home: DestinationItem(0, Icons.Filled.Home, Icons.Outlined.Home, Destinations.HOME_ROUTE)
    object News: DestinationItem(1, Icons.Filled.Feed, Icons.Outlined.Feed, Destinations.NEWS_ROUTE)
    object Settings: DestinationItem(2, Icons.Filled.Settings, Icons.Outlined.Settings, Destinations.SETTINGS_ROUTE)
}

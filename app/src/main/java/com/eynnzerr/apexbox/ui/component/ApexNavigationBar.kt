package com.eynnzerr.apexbox.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.eynnzerr.apexbox.data.model.general.DestinationItem
import com.eynnzerr.apexbox.ui.ext.popupTo

@Composable
fun ApexNavigationBar(
    navController: NavController,
) {
    NavigationBar(
        modifier = Modifier.padding(horizontal = 30.dp),
        containerColor = Color.Transparent
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        listOf(
            DestinationItem.Home,
            DestinationItem.News,
            DestinationItem.Settings
        ).forEach {  item ->
            val isSelected = currentDestination?.hierarchy?.any { it.route == item.route } == true
            NavigationBarItem(
                selected = isSelected,
                icon = {
                    Icon(
                        imageVector = if (isSelected) {
                            item.selectedIcon
                        } else {
                            item.unselectedIcon
                        },
                        contentDescription = item.toLabel()
                    )
                },
                onClick = { navController.popupTo(item.route) }
            )
        }
    }
}
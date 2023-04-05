package com.eynnzerr.apexbox.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.eynnzerr.apexbox.data.model.general.DestinationItem

@Composable
fun ApexNavigationBar(
    selectedIndex: Int,
    onItemClicked: (DestinationItem) -> Unit = {}
) {
    NavigationBar(
        modifier = Modifier.padding(horizontal = 30.dp),
        containerColor = Color.Transparent
    ) {
        listOf(
            DestinationItem.Home,
            DestinationItem.News,
            DestinationItem.Settings
        ).forEach {  item ->
            NavigationBarItem(
                selected = selectedIndex == item.index,
                icon = {
                    Icon(
                        imageVector = if (selectedIndex == item.index) {
                            item.selectedIcon
                        } else {
                            item.unselectedIcon
                        },
                        contentDescription = item.toLabel()
                    )
                },
                onClick = { onItemClicked(item) }
            )
        }
    }
}
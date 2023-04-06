package com.eynnzerr.apexbox.ui.page.player

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun PlatformSelectionItem(
    title: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    DropdownMenuItem(
        text = { Text(text = title) },
        onClick = onClick,
        trailingIcon = {
            if (selected) Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = null
            )
        }
    )
}
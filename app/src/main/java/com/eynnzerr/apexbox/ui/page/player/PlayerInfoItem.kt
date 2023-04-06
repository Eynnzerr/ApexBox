package com.eynnzerr.apexbox.ui.page.player

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun PlayerInfoItem(title: String, content: String) {
    Row(
        modifier = Modifier.padding(top = 6.dp, bottom = 6.dp, start = 12.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = content,
            modifier = Modifier.padding(start = 12.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
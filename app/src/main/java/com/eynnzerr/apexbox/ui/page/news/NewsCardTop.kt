package com.eynnzerr.apexbox.ui.page.news

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.eynnzerr.apexbox.data.model.bean.ApexNews

@Composable
fun NewsCardTop(news: ApexNews, modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        val imageModifier = Modifier
            .heightIn(min = 180.dp)
            .fillMaxWidth()
            .clip(shape = MaterialTheme.shapes.medium)
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(news.img)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = imageModifier
        )

        Spacer(Modifier.height(16.dp))

        Text(
            text = news.title,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 8.dp),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = news.short_desc,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 4.dp)
        )
    }
}
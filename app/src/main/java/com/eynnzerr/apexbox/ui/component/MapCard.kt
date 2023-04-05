package com.eynnzerr.apexbox.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.eynnzerr.apexbox.R
import com.eynnzerr.apexbox.ui.ext.mapNameToRes

@Composable
fun MapCard(
    modifier: Modifier = Modifier,
    mapName: String = "",
    modeName: String = "",
    startTime: String,
    endTime: String,
    remainingTime: String = ""
) {
    val url = mapNameToRes[mapName] ?: R.drawable.kings_canyon

    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = MaterialTheme.shapes.small
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                modifier = Modifier
                    .padding()
                    .height(160.dp)
                    .fillMaxSize(),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(url)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            // map name, remaining time(a timer emits value continuously), lasting period
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                MapInfoText(text = "$modeName: $mapName")
                MapInfoText(text = stringResource(id = R.string.remaining_time) + remainingTime)
                MapInfoText(text = stringResource(id = R.string.from) + startTime)
                MapInfoText(text = stringResource(id = R.string.to) + endTime)
            }
        }
    }
}

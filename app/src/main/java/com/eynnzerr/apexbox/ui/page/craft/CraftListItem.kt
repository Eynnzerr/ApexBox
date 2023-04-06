package com.eynnzerr.apexbox.ui.page.craft

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.eynnzerr.apexbox.data.model.bean.BundleContent
import com.eynnzerr.apexbox.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CraftListItem(
    bundle: BundleContent,
    modifier: Modifier,
    onClick: () -> Unit
) {
    // used data: bundleType, bundleContent(cost, itemType)
    ElevatedCard(
        modifier = modifier
            .width(180.dp),
        onClick = { onClick() },
        shape = MaterialTheme.shapes.small
    ) {
        Column {
            AsyncImage(
                modifier = Modifier
                    .padding()
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f, matchHeightConstraintsFirst = true),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(bundle.itemType.asset)  // image URL
                    .crossfade(true)
                    .build(),
                contentDescription = null, contentScale = ContentScale.FillWidth
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = bundle.itemType.name,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    // color = hexStringToColor(bundle.itemType.rarityHex)
                )
                Text(
                    modifier = Modifier.padding(top = 3.dp),
                    text = stringResource(id = R.string.cost) + bundle.cost,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

private fun hexStringToColor(hex: String): Color {
    val hexNum = hex.drop(1).toLongOrNull(16) ?: throw IllegalArgumentException("Invalid hex string: $hex")
    return Color(hexNum)
}

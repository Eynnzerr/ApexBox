package com.eynnzerr.apexbox.ui.component

import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun DisplayText(
    modifier: Modifier = Modifier,
    text: String,
) {
    Text(
        modifier = Modifier
            .height(44.dp),
        //                .animateContentSize(tween()),
        text = text,
        style = MaterialTheme.typography.displaySmall.copy(
            baselineShift = BaselineShift.Superscript
        ),
        color = MaterialTheme.colorScheme.onSurface,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun TitleText(
    modifier: Modifier = Modifier,
    text: String,
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.titleMedium.copy(
            baselineShift = BaselineShift.Superscript
        ),
        color = MaterialTheme.colorScheme.onSurface,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun MapInfoText(
    modifier: Modifier = Modifier,
    text: String,
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodyLarge.copy(
            baselineShift = BaselineShift.Superscript
        ),
        color = Color.White,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}

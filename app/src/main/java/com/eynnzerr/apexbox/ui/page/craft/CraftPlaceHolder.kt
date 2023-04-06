package com.eynnzerr.apexbox.ui.page.craft

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Token
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eynnzerr.apexbox.R

@Composable
fun CraftPlaceHolder() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        Icon(
            modifier = Modifier.size(150.dp),
            imageVector = Icons.Filled.Token,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primaryContainer
        )
        Text(
            text = stringResource(id = R.string.loading),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primaryContainer,
            fontWeight = FontWeight.Bold
        )
    }
}
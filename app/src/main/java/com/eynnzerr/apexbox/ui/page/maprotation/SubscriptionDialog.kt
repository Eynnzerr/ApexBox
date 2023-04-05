package com.eynnzerr.apexbox.ui.page.maprotation

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.eynnzerr.apexbox.R
import com.eynnzerr.apexbox.ui.ext.mapNames

@Composable
fun SubscriptionDialogContent(
    mapSelection: MutableList<Boolean>,
    onMapSelected: (Int, Boolean) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var expanded by remember { mutableStateOf(false) }

        Button(
            onClick = {
                expanded = true
            },
            elevation = null
        ) {
            Icon(
                imageVector = Icons.Filled.StarRate,
                contentDescription = stringResource(id = R.string.subscription_manage),
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(
                text = stringResource(id = R.string.subscription_manage),
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Box(
            modifier = Modifier
            .wrapContentSize(Alignment.TopStart)
        ) {

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                mapNames.forEachIndexed { index, s ->
                    MapSelectionItem(
                        title = s,
                        selected = mapSelection[index]
                    ) {
                        onMapSelected(index, !mapSelection[index])
                    }
                }
            }
        }

        Text(
            text = stringResource(id = R.string.subscription_desc),
            style = MaterialTheme.typography.bodySmall.copy(
                color = MaterialTheme.colorScheme.outline,
            ),
        )
    }
}
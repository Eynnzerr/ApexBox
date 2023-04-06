package com.eynnzerr.apexbox.ui.page.settings

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.eynnzerr.apexbox.R
import com.eynnzerr.apexbox.ui.component.ApexNavigationBar
import com.eynnzerr.apexbox.ui.component.ApexScaffold
import com.eynnzerr.apexbox.ui.component.Banner
import com.eynnzerr.apexbox.ui.ext.popupTo
import com.eynnzerr.apexbox.ui.ext.pushTo
import com.eynnzerr.apexbox.ui.navigation.Destinations
import com.eynnzerr.apexbox.ui.page.GlobalViewModel

@Composable
fun SettingsPage(
    navHostController: NavHostController,
) {
    val context = LocalContext.current

    ApexScaffold(
        title = { Text(text = stringResource(id = R.string.setting_bar_title)) },
        navigationIcon = {
            IconButton(onClick = {
                // TODO open drawer
            }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = ""
                )
            }
        },
        actions = {
            IconButton(onClick = {
                navHostController.pushTo(Destinations.HELP_ROUTE)
            }) {
                Icon(
                    imageVector = Icons.Outlined.HelpOutline,
                    contentDescription = ""
                )
            }
        },
        bottomBar = {
            ApexNavigationBar(navHostController)
        },
        content = {
            LazyColumn {
                item {
                    SettingGroupItem(
                        title = stringResource(id = R.string.item_api_key),
                        desc = stringResource(id = R.string.item_api_key_desc),
                        icon = Icons.Outlined.AccountCircle
                    ) {
                        // TODO navigate to API Key page
                        Toast.makeText(context, "This function will be ready very soon.", Toast.LENGTH_SHORT).show()
                    }
                }
                item {
                    SettingGroupItem(
                        title = stringResource(id = R.string.item_player_subscribed),
                        desc = stringResource(id = R.string.item_player_subscribed_desc),
                        icon = Icons.Outlined.VideogameAsset
                    ) {
                        // TODO navigate to player subscription
                        Toast.makeText(context, "This function will be ready very soon.", Toast.LENGTH_SHORT).show()
                    }
                }
                item {
                    SettingGroupItem(
                        title = stringResource(id = R.string.item_appearance),
                        desc = stringResource(id = R.string.item_appearance_desc),
                        icon = Icons.Outlined.Palette
                    ) {
                        // TODO navigate to appearance settings
                        Toast.makeText(context, "This function will be ready very soon.", Toast.LENGTH_SHORT).show()
                    }
                }
                item {
                    SettingGroupItem(
                        title = stringResource(id = R.string.item_languages),
                        desc = stringResource(id = R.string.item_languages_desc),
                        icon = Icons.Outlined.Language
                    ) {
                        // TODO navigate to language settings
                        Toast.makeText(context, "This function will be ready very soon.", Toast.LENGTH_SHORT).show()
                    }
                }
                item {
                    SettingGroupItem(
                        title = stringResource(id = R.string.item_about),
                        desc = stringResource(id = R.string.item_about_desc),
                        icon = Icons.Outlined.TipsAndUpdates
                    ) {
                        // TODO navigate to about page
                        navHostController.pushTo(Destinations.ABOUT_ROUTE)
                    }
                }
            }
        }
    )
}
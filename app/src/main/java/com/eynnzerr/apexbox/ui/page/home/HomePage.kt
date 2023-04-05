package com.eynnzerr.apexbox.ui.page.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.eynnzerr.apexbox.ui.component.ApexScaffold
import com.eynnzerr.apexbox.R
import com.eynnzerr.apexbox.ui.component.ApexNavigationBar
import com.eynnzerr.apexbox.ui.component.Banner
import com.eynnzerr.apexbox.ui.ext.popupTo
import com.eynnzerr.apexbox.ui.ext.pushTo
import com.eynnzerr.apexbox.ui.navigation.Destinations
import com.eynnzerr.apexbox.ui.page.GlobalViewModel

@Composable
fun HomePage(
    navHostController: NavHostController,
) {
    ApexScaffold(
        title = { Text(text = stringResource(id = R.string.home_bar_title)) },
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
                    Banner(
                        modifier = Modifier.padding(top = 12.dp),
                        title = stringResource(id = R.string.map_rotation),
                        icon = Icons.Outlined.Public,
                        desc = stringResource(id = R.string.map_desc),
                        action = {
                            Icon(
                                imageVector = Icons.Outlined.KeyboardArrowRight,
                                contentDescription = "",
                            )
                        },
                    ) {
                        navHostController.pushTo(Destinations.MAP_ROUTE)
                    }
                }
                item {
                    Banner(
                        modifier = Modifier.padding(top = 12.dp),
                        title = stringResource(id = R.string.craft_list),
                        icon = Icons.Outlined.Token,
                        desc = stringResource(id = R.string.craft_desc),
                        backgroundColor = MaterialTheme.colorScheme.surface,
                        action = {
                            Icon(
                                imageVector = Icons.Outlined.KeyboardArrowRight,
                                contentDescription = "",
                            )
                        },
                    ) {
                        // TODO Go to CraftListPage.
                    }
                }
                item {
                    Banner(
                        modifier = Modifier.padding(top = 12.dp),
                        title = stringResource(id = R.string.player_info),
                        icon = Icons.Outlined.Person,
                        desc = stringResource(id = R.string.player_desc),
                        backgroundColor = MaterialTheme.colorScheme.surface,
                        action = {
                            Icon(
                                imageVector = Icons.Outlined.KeyboardArrowRight,
                                contentDescription = "",
                            )
                        },
                    ) {
                        // TODO Go to CraftListPage.
                    }
                }
            }
        }
    )
}
package com.eynnzerr.apexbox.ui.page.player

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.eynnzerr.apexbox.R
import com.eynnzerr.apexbox.ui.component.ApexDialog
import com.eynnzerr.apexbox.ui.component.ApexScaffold
import com.eynnzerr.apexbox.ui.component.Subtitle
import com.eynnzerr.apexbox.ui.ext.mapNames
import com.eynnzerr.apexbox.ui.page.maprotation.MapSelectionItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerPage(
    navHostController: NavController,
    playerViewModel: PlayerViewModel
) {
    val uiState by playerViewModel.playerUiState.collectAsState()

    LaunchedEffect(true) {
        playerViewModel.clearState()
    }

    ApexDialog(
        visible = uiState.statsPreparing,
        onDismissRequest = { },
        icon = { Icon(imageVector = Icons.Outlined.Sync, contentDescription = "") },
        title = { Text(text = stringResource(id = R.string.loding_player)) },
        text = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                CircularProgressIndicator()
            }
        },
        confirmButton = {
            TextButton(
                onClick = { /*TODO*/ }
            ) {
                Text(text = stringResource(id = R.string.cancel))
            }
        }
    )

    ApexScaffold(
        title = { Text(text = stringResource(id = R.string.player_bar_title)) },
        navigationIcon = {
            IconButton(onClick = {
                navHostController.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = ""
                )
            }
        },
        actions = {
            IconButton(onClick = {
                // TODO update data.
            }) {
                Icon(
                    imageVector = Icons.Outlined.Refresh,
                    contentDescription = ""
                )
            }
        },
        content = {
            LazyColumn(
                modifier = Modifier.padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.End
            ) {
                item {
                    OutlinedTextField(
                        value = uiState.playerName,
                        onValueChange = { playerViewModel.updateInputName(it) },
                        label = { Text(stringResource(id = R.string.username)) },
                        modifier = Modifier
                            .fillMaxWidth(),
                        textStyle = MaterialTheme.typography.bodyLarge,
                        singleLine = true,
                        isError = uiState.playerNotExist,
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.AccountCircle,
                                contentDescription = ""
                            )
                        },
                        trailingIcon = {
                            IconButton(
                                onClick = { playerViewModel.updateInputName("") }
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.Cancel,
                                    contentDescription = ""
                                )
                            }
                        }
                    )
                }

                item {
                    var expanded by remember { mutableStateOf(false) }

                    OutlinedTextField(
                        value = uiState.platform,
                        onValueChange = { playerViewModel.updateInputName(it) },
                        label = { Text(stringResource(id = R.string.platform)) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 18.dp)
                            .clickable { expanded = !expanded },
                        textStyle = MaterialTheme.typography.bodyLarge,
                        singleLine = true,
                        readOnly = true,
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Computer,
                                contentDescription = ""
                            )
                        },
                        trailingIcon = {
                            Box(
                                modifier = Modifier
                                    .wrapContentSize(Alignment.TopStart)
                            ) {
                                IconButton(
                                    onClick = { expanded = !expanded }
                                ) {
                                    Icon(
                                        imageVector = if (expanded) Icons.Filled.ArrowDropDown else Icons.Filled.ArrowLeft,
                                        contentDescription = ""
                                    )
                                }

                                DropdownMenu(
                                    expanded = expanded,
                                    onDismissRequest = { expanded = false }
                                ) {
                                    listOf("PC", "PS4", "X1").forEach {
                                        PlatformSelectionItem(
                                            title = it,
                                            selected = it == uiState.platform
                                        ) {
                                            playerViewModel.updatePlatform(it)
                                            expanded = !expanded
                                        }
                                    }
                                }
                            }
                        }
                    )
                }

                item {
                    Button(
                        onClick = { playerViewModel.fetchPlayerStats() },
                        modifier = Modifier.padding(vertical = 18.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = stringResource(id = R.string.search),
                            modifier = Modifier.size(ButtonDefaults.IconSize)
                        )
                        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                        Text(
                            text = stringResource(id = R.string.search),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }

                if (uiState.statsReady) {
                    val stats = uiState.stats
                    item {
                        ElevatedCard(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp),
                            shape = MaterialTheme.shapes.small,
                        ) {
                            Subtitle(text = stringResource(id = R.string.basic_info), modifier = Modifier.padding(start = 12.dp))
                            PlayerInfoItem(title = stringResource(id = R.string.name), content = stats.global.name)
                            PlayerInfoItem(title = stringResource(id = R.string.uid), content = stats.global.uid.toString())
                            PlayerInfoItem(title = stringResource(id = R.string.level), content = stats.global.level.toString())
                            PlayerInfoItem(title = stringResource(id = R.string.to_next_level), content = stats.global.toNextLevelPercent.toString() + "%")

                            Subtitle(text = stringResource(id = R.string.rank_info), modifier = Modifier.padding(start = 12.dp))
                            PlayerInfoItem(title = stringResource(id = R.string.rank_name), content = stats.global.rank.rankName)
                            PlayerInfoItem(title = stringResource(id = R.string.score), content = stats.global.rank.rankScore.toString())
                            PlayerInfoItem(title = stringResource(id = R.string.season), content = stats.global.rank.rankedSeason)
                            PlayerInfoItem(title = stringResource(id = R.string.position), content = stats.global.rank.ladderPosPlatform.toString())

                            Subtitle(text = stringResource(id = R.string.status_info), modifier = Modifier.padding(start = 12.dp))
                            PlayerInfoItem(title = stringResource(id = R.string.account_status), content = stats.realtime.currentStateAsText)
                            PlayerInfoItem(title = stringResource(id = R.string.playing_legend), content = stats.realtime.selectedLegend)
                        }
                    }
                }
            }
        }
    )
}
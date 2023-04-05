package com.eynnzerr.apexbox.ui.page.maprotation

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.navigation.NavHostController
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.eynnzerr.apexbox.R
import com.eynnzerr.apexbox.ui.component.*
import com.eynnzerr.apexbox.ui.ext.mapNames
import com.eynnzerr.apexbox.worker.SubscriptionWorker
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MapRotationPage(
    navHostController: NavHostController,
    mapRotationViewModel: MapRotationViewModel
) {
    val context = LocalContext.current
    val uiState by mapRotationViewModel.mapUiState.collectAsState()

    ApexDialog(
        visible = uiState.openSubscriptionDialog,
        onDismissRequest = { mapRotationViewModel.updateDialogState() },
        icon = { Icon(imageVector = Icons.Outlined.Loyalty, contentDescription = "") },
        title = { Text(text = stringResource(id = R.string.map_dialog_title)) },
        text = {
            SubscriptionDialogContent(
                mapSelection = uiState.mapSelections,
                onMapSelected = { index, selected ->
                    // TODO 每次点都要访问MMKV编解码，造成一定延迟
                    mapRotationViewModel.updateMapSubscriptions(index, selected)
                }
            )
        },
        confirmButton = {
            TextButton(
                onClick = {
                    mapRotationViewModel.updateDialogState()
                    Toast.makeText(context, context.resources.getText(R.string.toast_subscription), Toast.LENGTH_SHORT).show()

                    WorkManager.getInstance(context).apply {
                        cancelAllWork()
                        val subscribedMaps = uiState.mapSelections
                            .mapIndexed { index, selected -> if (selected) mapNames[index] else null }
                            .filterNotNull()
                            .toTypedArray()
                        val data = Data.Builder()
                            .putStringArray("subscribed_maps", subscribedMaps)
                            .build()
                        enqueue(OneTimeWorkRequestBuilder<SubscriptionWorker>()
                            .setInputData(data)
                            .build()
                        )
                    }
                }
            ) {
                Text(text = stringResource(id = R.string.map_dialog_confirm))
            }
        }
    )

    ApexScaffold(
        title = { Text(text = stringResource(id = R.string.map_bar_title)) },
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
                mapRotationViewModel.fetchMapRotation()
            }) {
                Icon(
                    imageVector = Icons.Outlined.Refresh,
                    contentDescription = ""
                )
            }
            IconButton(onClick = {
                mapRotationViewModel.updateDialogState()
            }) {
                Icon(
                    imageVector = Icons.Outlined.BookmarkAdd,
                    contentDescription = ""
                )
            }
        },
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                item {
                    val pagerState = rememberPagerState()
                    // val scope = rememberCoroutineScope()
                    Column {
                        TitleText(
                            modifier = Modifier.padding(start = 10.dp),
                            text = stringResource(id = R.string.battle_royale)
                        )
//                        TabRow(
//                            selectedTabIndex = pagerState.settledPage,
//                            modifier = Modifier.width(180.dp)
//                        ) {
//                            Tab(
//                                selected = pagerState.settledPage == 0,
//                                onClick = { scope.launch { pagerState.animateScrollToPage(0) } },
//                                text = {
//                                    Text(
//                                        text = stringResource(id = R.string.current),
//                                        style = MaterialTheme.typography.bodyLarge
//                                    )
//                                }
//                            )
//                            Tab(
//                                selected = pagerState.settledPage == 1,
//                                onClick = { scope.launch { pagerState.animateScrollToPage(1) } },
//                                text = {
//                                    Text(
//                                        text = stringResource(id = R.string.next),
//                                        style = MaterialTheme.typography.bodyLarge
//                                    )
//                                }
//                            )
//                        }

                        HorizontalPager(
                            pageCount = 2,
                            state = pagerState,
                        ) { page ->
                            val maps = uiState.mapRotation.battle_royale
                            if (page == 0) {
                                MapCard(
                                    modifier = Modifier.graphicsLayer {
                                        val pageOffset = (
                                                (pagerState.currentPage - page) + pagerState
                                                    .currentPageOffsetFraction
                                                ).absoluteValue

                                        // We animate the alpha, between 50% and 100%
                                        alpha = lerp(
                                            start = 0.5f,
                                            stop = 1f,
                                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                        )
                                    },
                                    mapName = maps.current.map,
                                    modeName = "BR",
                                    startTime = adjustDate(maps.current.readableDate_start),
                                    endTime = adjustDate(maps.current.readableDate_end),
                                    remainingTime = uiState.commonCountDownTime
                                )
                            } else {
                                MapCard(
                                    mapName = maps.next.map,
                                    modeName = "BR",
                                    startTime = adjustDate(maps.next.readableDate_start),
                                    endTime = adjustDate(maps.next.readableDate_end),
                                    remainingTime = stringResource(id = R.string.not_started)
                                )
                            }
                        }
                    }
                }

                item {
                    val pagerState = rememberPagerState()
                    // val scope = rememberCoroutineScope()
                    Column {
                        TitleText(
                            modifier = Modifier.padding(start = 10.dp, top = 20.dp),
                            text = stringResource(id = R.string.br_Arena)
                        )
                        HorizontalPager(
                            pageCount = 2,
                            state = pagerState,
                        ) { page ->
                            val maps = uiState.mapRotation.ranked
                            if (page == 0) {
                                MapCard(
                                    modifier = Modifier.graphicsLayer {
                                        val pageOffset = (
                                                (pagerState.currentPage - page) + pagerState
                                                    .currentPageOffsetFraction
                                                ).absoluteValue

                                        // We animate the alpha, between 50% and 100%
                                        alpha = lerp(
                                            start = 0.5f,
                                            stop = 1f,
                                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                        )
                                    },
                                    mapName = maps.current.map,
                                    modeName = "Rank",
                                    startTime = adjustDate(maps.current.readableDate_start),
                                    endTime = adjustDate(maps.current.readableDate_end),
                                    remainingTime = uiState.rankCountDownTime
                                )
                            } else {
                                MapCard(
                                    mapName = maps.next.map,
                                    modeName = "Rank",
                                    startTime = adjustDate(maps.next.readableDate_start),
                                    endTime = adjustDate(maps.next.readableDate_end),
                                    remainingTime = stringResource(id = R.string.not_started)
                                )
                            }
                        }
                    }
                }

                item {
                    val pagerState = rememberPagerState()
                    Column {
                        TitleText(
                            modifier = Modifier.padding(start = 10.dp, top = 20.dp),
                            text = stringResource(id = R.string.mix_tape)
                        )
                        HorizontalPager(
                            pageCount = 2,
                            state = pagerState,
                        ) { page ->
                            val maps = uiState.mapRotation.ltm
                            if (page == 0) {
                                MapCard(
                                    modifier = Modifier.graphicsLayer {
                                        val pageOffset = (
                                                (pagerState.currentPage - page) + pagerState
                                                    .currentPageOffsetFraction
                                                ).absoluteValue

                                        // We animate the alpha, between 50% and 100%
                                        alpha = lerp(
                                            start = 0.5f,
                                            stop = 1f,
                                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                        )
                                    },
                                    mapName = maps.current.map,
                                    modeName = maps.current.eventName,
                                    startTime = adjustDate(maps.current.readableDate_start),
                                    endTime = adjustDate(maps.current.readableDate_end),
                                    remainingTime = uiState.mixTapeCountDownTime
                                )
                            } else {
                                MapCard(
                                    mapName = maps.next.map,
                                    modeName = maps.next.eventName,
                                    startTime = adjustDate(maps.next.readableDate_start),
                                    endTime = adjustDate(maps.next.readableDate_end),
                                    remainingTime = stringResource(id = R.string.not_started)
                                )
                            }
                        }
                    }
                }
            }
        }
    )
}

private fun adjustDate(date: String) = if (date == "00:00:00") date else with(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) {
    LocalDateTime.parse(date, this).plusHours(8).format(this)
}
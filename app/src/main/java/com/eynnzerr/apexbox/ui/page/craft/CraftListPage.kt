package com.eynnzerr.apexbox.ui.page.craft

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.eynnzerr.apexbox.R
import com.eynnzerr.apexbox.data.model.bean.CraftItem
import com.eynnzerr.apexbox.ui.component.ApexScaffold
import com.eynnzerr.apexbox.ui.component.TitleText

@Composable
fun CraftListPage(
    navHostController: NavHostController,
    craftListViewModel: CraftListViewModel
) {
    val uiState by craftListViewModel.craftUiState.collectAsState()

    ApexScaffold(
        title = { Text(text = stringResource(id = R.string.craft_bar_title)) },
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
                craftListViewModel.fetchNewCrafts()
            }) {
                Icon(
                    imageVector = Icons.Outlined.Refresh,
                    contentDescription = ""
                )
            }
        },
        content = {
            if (uiState.craftList.isEmpty()) {
                CraftPlaceHolder()
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {
                    item {
                        TitleText(
                            modifier = Modifier.padding(start = 10.dp),
                            text = stringResource(id = R.string.daily)
                        )
                    }
                    item {
                        LazyRow {
                            uiState.craftList
                                .filter { it.bundleType == CraftItem.TYPE_DAILY}
                                .map { it.bundleContent }
                                .forEach {
                                    items(it) { bundle ->
                                        CraftListItem(
                                            bundle,
                                            modifier = Modifier.padding(horizontal = 10.dp)
                                        ) {

                                        }
                                    }
                                }
                        }
                    }
                    item {
                        TitleText(
                            modifier = Modifier.padding(start = 10.dp, top = 20.dp),
                            text = stringResource(id = R.string.weekly)
                        )
                    }
                    item {
                        LazyRow {
                            uiState.craftList
                                .filter { it.bundleType == CraftItem.TYPE_WEEKLY}
                                .map { it.bundleContent }
                                .forEach {
                                    items(it) { bundle ->
                                        CraftListItem(
                                            bundle,
                                            modifier = Modifier.padding(horizontal = 10.dp)
                                        ) {

                                        }
                                    }
                                }
                        }
                    }
                    item {
                        TitleText(
                            modifier = Modifier.padding(start = 10.dp, top = 20.dp),
                            text = stringResource(id = R.string.permanently)
                        )
                    }
                    item {
                        LazyRow {
                            uiState.craftList
                                .filter { it.bundleType == CraftItem.TYPE_PERMANENTLY}
                                .map { it.bundleContent }
                                .forEach {
                                    items(it) { bundle ->
                                        CraftListItem(
                                            bundle,
                                            modifier = Modifier.padding(horizontal = 10.dp)
                                        ) {

                                        }
                                    }
                                }
                        }
                    }
                }
            }
        }
    )
}
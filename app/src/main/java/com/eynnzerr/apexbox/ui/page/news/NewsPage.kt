package com.eynnzerr.apexbox.ui.page.news

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.eynnzerr.apexbox.R
import com.eynnzerr.apexbox.ui.component.ApexNavigationBar
import com.eynnzerr.apexbox.ui.component.ApexScaffold
import com.eynnzerr.apexbox.ui.ext.pushTo
import com.eynnzerr.apexbox.ui.ext.startBrowser
import com.eynnzerr.apexbox.ui.navigation.Destinations

@Composable
fun NewsPage(
    navHostController: NavHostController,
    newsViewModel: NewsViewModel
) {
    val context = LocalContext.current
    val uiState by newsViewModel.newsUiState.collectAsState()

    ApexScaffold(
        title = { Text(text = stringResource(id = R.string.news_bar_title)) },
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
            LazyColumn(
                modifier = Modifier
            ) {
                if (uiState.news.isNotEmpty()) {
                    item {
                        NewsCardTop(
                            news = uiState.news.first(),
                            modifier = Modifier.clickable {
                                startBrowser(uiState.news.first().link, context)
                            }
                        )
                        NewsDivider()
                    }
                }
                if (uiState.news.size > 1) {
                    items(uiState.news.drop(1)) {
                        NewsCard(
                            news = it,
                            modifier = Modifier.clickable {
                                startBrowser(it.link, context)
                            }
                        )
                    }
                }
            }
        }
    )

}
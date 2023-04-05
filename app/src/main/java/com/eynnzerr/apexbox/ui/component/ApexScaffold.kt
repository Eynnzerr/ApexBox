package com.eynnzerr.apexbox.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.eynnzerr.apexbox.ui.ext.surfaceColorAtElevation

// Used by every single page.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApexScaffold(
    containerColor: Color = MaterialTheme.colorScheme.surface,
    topBarTonalElevation: Dp = 0.dp,
    containerTonalElevation: Dp = 0.dp,
    appBarScrollable: Boolean = true,
    title: @Composable () -> Unit = {},
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    content: @Composable () -> Unit = {},
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        modifier = Modifier
            .appBarScroll(appBarScrollable, scrollBehavior)
            .background(
                MaterialTheme.colorScheme.surfaceColorAtElevation(
                    topBarTonalElevation,
                    containerColor
                )
            ),
        containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(
            containerTonalElevation,
            containerColor
        ),
        topBar = {
            LargeTopAppBar(
                title = title,
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(
                        topBarTonalElevation,
                        containerColor
                    ),
                ),
                navigationIcon = navigationIcon,
                actions = actions,
                scrollBehavior = scrollBehavior
            )
        },
        content = {
            Column {
                Spacer(modifier = Modifier.height(it.calculateTopPadding()))
                content()
            }
        },
        bottomBar = bottomBar,
        floatingActionButton = floatingActionButton,
    )
}

@SuppressLint("ModifierFactoryUnreferencedReceiver")
@OptIn(ExperimentalMaterial3Api::class)
private fun Modifier.appBarScroll(scrollable: Boolean, topAppBarScrollBehavior: TopAppBarScrollBehavior) = if (scrollable) Modifier.nestedScroll(topAppBarScrollBehavior.nestedScrollConnection) else Modifier
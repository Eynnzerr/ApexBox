package com.eynnzerr.apexbox.ui.page.help

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircleOutline
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.eynnzerr.apexbox.R
import com.eynnzerr.apexbox.data.preference.MMKVAgent
import com.eynnzerr.apexbox.data.preference.PreferenceKeys
import com.eynnzerr.apexbox.ui.component.ApexScaffold
import com.eynnzerr.apexbox.ui.component.DisplayText
import com.eynnzerr.apexbox.ui.ext.popupTo
import com.eynnzerr.apexbox.ui.ext.pushTo
import com.eynnzerr.apexbox.ui.ext.startBrowser
import com.eynnzerr.apexbox.ui.navigation.Destinations

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelpPage(
    navHostController: NavHostController
) {
    // This page has only one state so there's no need to create a viewModel.
    var apiKey by remember { mutableStateOf("") }
    val context = LocalContext.current

    ApexScaffold(
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 24.dp,
                        top = 48.dp,
                        end = 24.dp,
                        bottom = 24.dp,
                    )
                    .navigationBarsPadding(),
            ) {
                item {
                    DisplayText(
                        modifier = Modifier.padding(top = 64.dp),
                        text = stringResource(R.string.welcome)
                    )
                }
                item {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp, bottom = 12.dp),
                        text = stringResource(R.string.help_content1),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                item {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp, bottom = 12.dp),
                        text = stringResource(R.string.help_content2),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                item {
                    ClickableText(
                        text = buildAnnotatedString { append(stringResource(id = R.string.api_site)) },
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = MaterialTheme.colorScheme.primary,
                        ),
                        onClick = {
                            // Go to api website
                            startBrowser(context.resources.getString(R.string.api_site), context)
                        }
                    )
                }
                item {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp, bottom = 12.dp),
                        text = stringResource(R.string.help_content3),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                item {
                    OutlinedTextField(
                        value = apiKey,
                        onValueChange = { apiKey = it },
                        label = { Text(stringResource(id = R.string.textfield_label)) },
                        modifier = Modifier
                            .fillMaxWidth(), textStyle = MaterialTheme.typography.bodyLarge, maxLines = 3
                    )
                }

                item {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp, bottom = 12.dp),
                        text = stringResource(R.string.help_content4),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                item {
                    ClickableText(
                        text = buildAnnotatedString { append(stringResource(id = R.string.open_policy)) },
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.outline,
                        ),
                        onClick = {
                            // TODO open dialog
                        }
                    )
                }
            }
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                modifier = Modifier.navigationBarsPadding(),
                onClick = {
                    // 导航至HomePage，并且设置键值对为true，下次直接进入HomePage
                    MMKVAgent.encodeString(PreferenceKeys.API_KEY, if (apiKey.isEmpty()) "a37d462c48cb38b1b48c75f772918165" else apiKey)
                    MMKVAgent.encodeBoolean(PreferenceKeys.FIRST_LAUNCH_KEY, true)
                    navHostController.popupTo(Destinations.HOME_ROUTE)
                },
                icon = {
                    Icon(
                        Icons.Rounded.CheckCircleOutline,
                        stringResource(R.string.btn_agree)
                    )
                },
                text = { Text(text = stringResource(R.string.btn_agree)) },
            )
        },
        appBarScrollable = false
    )
}


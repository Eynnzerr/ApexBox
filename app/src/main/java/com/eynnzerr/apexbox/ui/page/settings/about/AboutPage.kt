package com.eynnzerr.apexbox.ui.page.settings.about

import android.widget.Toast
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.eynnzerr.apexbox.R
import com.eynnzerr.apexbox.ui.component.ApexScaffold
import com.eynnzerr.apexbox.ui.ext.startBrowser
import com.eynnzerr.apexbox.ui.page.settings.SettingGroupItem

@Composable
fun AboutPage(navHostController: NavController) {
    val context = LocalContext.current
    val versionName = context.packageManager.getPackageInfo(context.packageName, 0).versionName
    ApexScaffold(
        title = { Text(text = stringResource(id = R.string.about_bar_title)) },
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
        actions = { },
        bottomBar = { },
        content = {
            LazyColumn {
                item {
                    SettingGroupItem(
                        title = stringResource(id = R.string.version),
                        desc = versionName,
                        painter = painterResource(id = R.drawable.info)
                    ) {
                        Toast.makeText(context, "Already newest version.", Toast.LENGTH_SHORT).show()
                    }
                }
                item {
                    SettingGroupItem(
                        title = stringResource(id = R.string.author),
                        desc = stringResource(id = R.string.author_name),
                        painter = painterResource(id = R.drawable.personal)
                    ) {
                        startBrowser("http://eynnzerr.top", context)
                    }
                }
                item {
                    SettingGroupItem(
                        title = stringResource(id = R.string.github),
                        desc = stringResource(id = R.string.github_url),
                        painter = painterResource(id = R.drawable.github)
                    ) {
                        startBrowser(context.resources.getString(R.string.github_url), context)
                    }
                }
                item {
                    SettingGroupItem(
                        title = stringResource(id = R.string.libraries),
                        desc = stringResource(id = R.string.libraries_description),
                        painter = painterResource(id = R.drawable.library)
                    ) {

                    }
                }
            }
        }
    )
}
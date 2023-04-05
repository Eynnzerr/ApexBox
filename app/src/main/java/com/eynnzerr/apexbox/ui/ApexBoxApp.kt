package com.eynnzerr.apexbox.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.eynnzerr.apexbox.data.preference.MMKVAgent
import com.eynnzerr.apexbox.data.preference.PreferenceKeys
import com.eynnzerr.apexbox.ui.navigation.Destinations
import com.eynnzerr.apexbox.ui.navigation.NavGraph
import com.eynnzerr.apexbox.ui.theme.ApexBoxTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ApexBoxApp() {
    ApexBoxTheme {
        val navHostController = rememberAnimatedNavController()
        val starDestination = if (MMKVAgent.containsKey(PreferenceKeys.FIRST_LAUNCH_KEY)) Destinations.HOME_ROUTE else Destinations.HELP_ROUTE
        NavGraph(navHostController, starDestination)
    }
}
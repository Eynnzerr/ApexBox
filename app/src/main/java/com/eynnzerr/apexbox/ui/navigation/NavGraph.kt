package com.eynnzerr.apexbox.ui.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.*
import com.eynnzerr.apexbox.ui.page.GlobalViewModel
import com.eynnzerr.apexbox.ui.page.craft.CraftListPage
import com.eynnzerr.apexbox.ui.page.craft.CraftListViewModel
import com.eynnzerr.apexbox.ui.page.help.HelpPage
import com.eynnzerr.apexbox.ui.page.home.HomePage
import com.eynnzerr.apexbox.ui.page.maprotation.MapRotationPage
import com.eynnzerr.apexbox.ui.page.maprotation.MapRotationViewModel
import com.eynnzerr.apexbox.ui.page.news.NewsPage
import com.eynnzerr.apexbox.ui.page.news.NewsViewModel
import com.eynnzerr.apexbox.ui.page.player.PlayerPage
import com.eynnzerr.apexbox.ui.page.player.PlayerViewModel
import com.eynnzerr.apexbox.ui.page.settings.SettingsPage
import com.eynnzerr.apexbox.ui.page.settings.about.AboutPage
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph(
    navHostController: NavHostController = rememberAnimatedNavController(),
    startDestination: String = Destinations.HELP_ROUTE
) {
    AnimatedNavHost(
        modifier = Modifier.background(MaterialTheme.colorScheme.surface),
        navController = navHostController,
        startDestination = startDestination,
    ) {
        animatedComposable(Destinations.HELP_ROUTE) {
            HelpPage(navHostController)
        }
        animatedComposable(Destinations.HOME_ROUTE) {
            HomePage(navHostController)
        }
        animatedComposable(Destinations.MAP_ROUTE) {
            val viewModel = hiltViewModel<MapRotationViewModel>()
            MapRotationPage(navHostController, viewModel)
        }
        animatedComposable(Destinations.CRAFT_ROUTE) {
            val viewModel = hiltViewModel<CraftListViewModel>()
            CraftListPage(navHostController, viewModel)
        }
        animatedComposable(Destinations.PLAYER_ROUTE) {
            val viewModel = hiltViewModel<PlayerViewModel>()
            PlayerPage(navHostController, viewModel)
        }
        animatedComposable(Destinations.NEWS_ROUTE) {
            val viewModel = hiltViewModel<NewsViewModel>()
            NewsPage(navHostController, viewModel)
        }
        animatedComposable(Destinations.SETTINGS_ROUTE) {
            SettingsPage(navHostController)
        }
        animatedComposable(Destinations.ABOUT_ROUTE) {
            AboutPage(navHostController)
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
private fun NavGraphBuilder.animatedComposable(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit,
) = composable(
    route = route,
    arguments = arguments,
    deepLinks = deepLinks,
    enterTransition = {
        fadeIn(animationSpec = tween(220, delayMillis = 90)) +
                scaleIn(
                    initialScale = 0.92f,
                    animationSpec = tween(220, delayMillis = 90)
                )
    },
    exitTransition = {
        fadeOut(animationSpec = tween(90))
    },
    popEnterTransition = {
        fadeIn(animationSpec = tween(220, delayMillis = 90)) +
                scaleIn(
                    initialScale = 0.92f,
                    animationSpec = tween(220, delayMillis = 90)
                )
    },
    popExitTransition = {
        fadeOut(animationSpec = tween(90))
    },
    content = content
)
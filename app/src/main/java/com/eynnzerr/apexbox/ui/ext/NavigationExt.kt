package com.eynnzerr.apexbox.ui.ext

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

fun NavController.popupTo(route: String) {
    navigate(route) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

fun NavController.pushTo(route: String) {
    navigate(route) {
        launchSingleTop = true
        restoreState = true
    }
}
package com.example.thermalgapcalc_compose.presentation.navigation.nav_graph

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.thermalgapcalc_compose.presentation.navigation.SETTINGS_ROUTE
import com.example.thermalgapcalc_compose.presentation.navigation.Screen
import com.example.thermalgapcalc_compose.presentation.screens.SettingsScreen

fun NavGraphBuilder.settingsNavGraph(navController: NavHostController) {
    navigation(startDestination = Screen.Settings.route, route = SETTINGS_ROUTE) {
        composable(Screen.Settings.route) {
            SettingsScreen(modifier = Modifier)
        }
    }
}
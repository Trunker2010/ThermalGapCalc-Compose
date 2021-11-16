package com.example.thermalgapcalc_compose.presentation.navigation.nav_graph

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.thermalgapcalc_compose.presentation.navigation.NavigationRoute
import com.example.thermalgapcalc_compose.presentation.screens.SettingsScreen

fun NavGraphBuilder.settingsNavGraph(navController: NavHostController){
    navigation(startDestination = NavigationRoute.SETTINGS,route=NavigationRoute.SETTINGS_ROUTE){
        composable(NavigationRoute.SETTINGS) {
            SettingsScreen(modifier = Modifier)
        }
    }
}
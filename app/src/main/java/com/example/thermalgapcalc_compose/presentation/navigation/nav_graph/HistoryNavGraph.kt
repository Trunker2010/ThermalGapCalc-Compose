package com.example.thermalgapcalc_compose.presentation.navigation.nav_graph

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.thermalgapcalc_compose.presentation.navigation.HISTORY_ROUTE
import com.example.thermalgapcalc_compose.presentation.navigation.Screen
import com.example.thermalgapcalc_compose.presentation.screens.rootScreen.RootScreen
import com.example.thermalgapcalc_compose.presentation.screens.rootScreen.model.RootScreenViewModelViewModel

@ExperimentalFoundationApi
@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.historyNavGraph(navController: NavHostController) {
    navigation(
        startDestination = Screen.History.route,
        route = HISTORY_ROUTE
    ) {

        composable(route = Screen.History.route) {
            val rootScreenViewModelViewModel = hiltViewModel<RootScreenViewModelViewModel>()
            RootScreen.RootScreen(navController = navController, rootScreenViewModelViewModel)
        }
    }
}
package com.example.thermalgapcalc_compose.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.thermalgapcalc_compose.presentation.navigation.nav_graph.addNavGraph
import com.example.thermalgapcalc_compose.presentation.navigation.nav_graph.historyNavGraph
import com.example.thermalgapcalc_compose.presentation.navigation.nav_graph.settingsNavGraph

object Navigation {
    @ExperimentalFoundationApi
    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun NavigationComponent(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = HISTORY_ROUTE,
            route = ROOT_GRAPH_ROUTE
        ) {
            historyNavGraph(navController = navController)
            addNavGraph(navController = navController)
            settingsNavGraph(navController = navController)
        }
    }
}
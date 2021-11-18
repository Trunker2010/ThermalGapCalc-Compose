package com.example.thermalgapcalc_compose.presentation.navigation.nav_graph

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.thermalgapcalc_compose.presentation.navigation.DETAIL_ARGUMENT_KEY
import com.example.thermalgapcalc_compose.presentation.navigation.HISTORY_ROUTE
import com.example.thermalgapcalc_compose.presentation.navigation.Screen
import com.example.thermalgapcalc_compose.presentation.screens.rootScreen.RootScreen
import com.example.thermalgapcalc_compose.presentation.screens.rootScreen.model.RootScreenViewModelViewModel
import com.example.thermalgapcalc_compose.presentation.screens.savedDetailsScreen.SavedDetails
import com.example.thermalgapcalc_compose.presentation.screens.savedDetailsScreen.model.SavedDetailsViewModel

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
        composable(
            route = Screen.SavedDetails.route,
            arguments = listOf(
                navArgument(DETAIL_ARGUMENT_KEY) {
                    type = NavType.StringType
                    defaultValue = "id"
                }
            )
        ) {
            val id = it.arguments?.getString(DETAIL_ARGUMENT_KEY)
            val savedDetailsViewModel = hiltViewModel<SavedDetailsViewModel>()
            SavedDetails(navController = navController, viewModel = savedDetailsViewModel,id!!)
        }
    }
}
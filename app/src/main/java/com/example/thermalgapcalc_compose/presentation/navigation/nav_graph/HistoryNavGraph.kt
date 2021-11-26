package com.example.thermalgapcalc_compose.presentation.navigation.nav_graph

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.thermalgapcalc_compose.presentation.navigation.*
import com.example.thermalgapcalc_compose.presentation.screens.rootScreen.RootScreen
import com.example.thermalgapcalc_compose.presentation.screens.rootScreen.model.RootScreenViewModelViewModel
import com.example.thermalgapcalc_compose.presentation.screens.savedCalcScreen.SavedCalcScreen
import com.example.thermalgapcalc_compose.presentation.screens.savedCalcScreen.model.SavedCalcViewModel
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
                navArgument(DETAIL_ID_KEY) {
                    type = NavType.StringType
                    defaultValue = "null"
                },
                navArgument(DETAIL_EX_GAP_NORMAL_KEY) {
                    type = NavType.FloatType
                    defaultValue = 0f
                },
                navArgument(DETAIL_EX_GAP_TOLERANCE_KEY) {
                    type = NavType.FloatType
                    defaultValue = 0f
                },
                navArgument(DETAIL_IN_GAP_NORMAL_KEY) {
                    type = NavType.FloatType
                    defaultValue = 0f
                },
                navArgument(DETAIL_IN_GAP_TOLERANCE_KEY) {
                    type = NavType.FloatType
                    defaultValue = 0f
                }
            )
        ) {
            val savedDetailsViewModel = hiltViewModel<SavedDetailsViewModel>()
            it.arguments?.apply {
                val id = getString(DETAIL_ID_KEY)
                val exGapNormal: Float = getFloat(DETAIL_EX_GAP_NORMAL_KEY)
                val exGapTolerance: Float = getFloat(DETAIL_EX_GAP_TOLERANCE_KEY)
                val inGapNormal: Float = getFloat(DETAIL_IN_GAP_NORMAL_KEY)
                val inGapTolerance: Float = getFloat(DETAIL_IN_GAP_TOLERANCE_KEY)
                SavedDetails(
                    navController = navController,
                    viewModel = savedDetailsViewModel,
                    id = id!!,
                    exGapNormal = exGapNormal,
                    exGapTolerance = exGapTolerance,
                    inGapNormal = inGapNormal,
                    inGapTolerance = inGapTolerance
                )
            }
        }

        composable(
            route = Screen.SavedResult.route,
            arguments = listOf(
                    navArgument(DETAIL_ID_KEY) {
                        type = NavType.StringType
                        defaultValue = "null"
                    },
                    navArgument(DETAIL_EX_GAP_NORMAL_KEY) {
                        type = NavType.FloatType
                        defaultValue = 0f
                    },
                    navArgument(DETAIL_EX_GAP_TOLERANCE_KEY) {
                        type = NavType.FloatType
                        defaultValue = 0f
                    },
                    navArgument(DETAIL_IN_GAP_NORMAL_KEY) {
                        type = NavType.FloatType
                        defaultValue = 0f
                    },
                    navArgument(DETAIL_IN_GAP_TOLERANCE_KEY) {
                        type = NavType.FloatType
                        defaultValue = 0f
                    }
                )
        ) {
            val savedCalcViewModel = hiltViewModel<SavedCalcViewModel>()
            it.arguments?.apply {
                val id = getString(DETAIL_ID_KEY)
                val exGapNormal: Float = getFloat(DETAIL_EX_GAP_NORMAL_KEY)
                val exGapTolerance: Float = getFloat(DETAIL_EX_GAP_TOLERANCE_KEY)
                val inGapNormal: Float = getFloat(DETAIL_IN_GAP_NORMAL_KEY)
                val inGapTolerance: Float = getFloat(DETAIL_IN_GAP_TOLERANCE_KEY)
                SavedCalcScreen(
                    navController = navController,
                    viewModel = savedCalcViewModel,
                    id = id!!,
                    exGapNormal = exGapNormal,
                    exGapTolerance = exGapTolerance,
                    inGapNormal = inGapNormal,
                    inGapTolerance = inGapTolerance
                )

            }
        }
    }
}
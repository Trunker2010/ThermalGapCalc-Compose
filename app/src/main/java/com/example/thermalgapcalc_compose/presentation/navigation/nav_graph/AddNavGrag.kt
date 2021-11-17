package com.example.thermalgapcalc_compose.presentation.navigation.nav_graph

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.thermalgapcalc_compose.presentation.navigation.ADD_ROUTE
import com.example.thermalgapcalc_compose.presentation.navigation.Screen
import com.example.thermalgapcalc_compose.presentation.screens.addingCylinderScreen.AddingCylinderScreen
import com.example.thermalgapcalc_compose.presentation.screens.addingCylinderScreen.AddingCylinderViewModel
import com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.EngineSettingsScreen
import com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.model.EngineSettingsViewModel
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.EngineValveScreen
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.ParamsCard.ParamsCardViewModel
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.cylinderHolder.CylinderCardsViewModel
import com.example.thermalgapcalc_compose.presentation.screens.resultScreen.ResultScreen
import com.example.thermalgapcalc_compose.presentation.screens.resultScreen.model.ResultViewModel

fun NavGraphBuilder.addNavGraph(navController: NavHostController) {
    navigation(
        startDestination = Screen.EngineSettings.route,
        route = ADD_ROUTE
    ) {
        composable(route = Screen.EngineSettings.route) {
            val engineSettingsViewModel = hiltViewModel<EngineSettingsViewModel>()
            EngineSettingsScreen.EngineSettingsScreen(
                navController = navController,
                viewModel = engineSettingsViewModel
            )
        }
        composable(route = Screen.ValveSettings.route) {
            val cylinderCardsViewModel = hiltViewModel<CylinderCardsViewModel>()
            val paramsCardViewModel = hiltViewModel<ParamsCardViewModel>()
            EngineValveScreen.EngineValveScreen(
                pramCardsViewModel = paramsCardViewModel,
                navController = navController,
                cardsViewModel = cylinderCardsViewModel
            )
        }
        composable(route = Screen.AddingMeasurementsCylinder.route) {
            val addingViewModel = hiltViewModel<AddingCylinderViewModel>()
            AddingCylinderScreen.AddingCylinderScreen(viewModel = addingViewModel)
        }

        composable(route = Screen.MeasurementResult.route) {
            val resultViewModel = hiltViewModel<ResultViewModel>()
            ResultScreen.ResultScreen(
                viewModel = resultViewModel,
                navController = navController,
            )
        }
    }
}
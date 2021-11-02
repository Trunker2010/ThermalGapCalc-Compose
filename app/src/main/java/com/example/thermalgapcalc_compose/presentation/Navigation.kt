package com.example.thermalgapcalc_compose.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.thermalgapcalc_compose.NavigationRoute
import com.example.thermalgapcalc_compose.presentation.screens.addingCylinderScreen.AddingCylinderScreen.AddingCylinderScreen
import com.example.thermalgapcalc_compose.presentation.screens.addingCylinderScreen.AddingCylinderViewModel
import com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.EngineSettingsScreen
import com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.model.EngineSettingsViewModel
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.EngineValveScreen
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.ParamsCard.ParamsCardViewModel
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.cylinderHolder.CylinderCardsViewModel
import com.example.thermalgapcalc_compose.presentation.screens.resultScreen.ResultScreen
import com.example.thermalgapcalc_compose.presentation.screens.resultScreen.model.ResultViewModel
import com.example.thermalgapcalc_compose.presentation.screens.rootScreen.RootScreen

object Navigation {
    @Composable
    fun NavigationComponent(navController: NavHostController) {

        NavHost(
            navController = navController,
            startDestination = NavigationRoute.ROOT
        ) {
            composable(NavigationRoute.ROOT) {
                RootScreen.RootScreen(navController = navController)
            }

            composable(NavigationRoute.ENGINE_SETTINGS) {
                val viewModel = hiltViewModel<EngineSettingsViewModel>()
                EngineSettingsScreen.EngineSettingsScreen(
                    navController = navController,
                    viewModel = viewModel
                )
            }
            composable(NavigationRoute.VALVE_SETTINGS) {
                val cylinderCardsViewModel = hiltViewModel<CylinderCardsViewModel>()
                val paramsCardViewModel = hiltViewModel<ParamsCardViewModel>()
                EngineValveScreen.EngineValveScreen(
                    pramCardsViewModel = paramsCardViewModel,
                    navController = navController,
                    cardsViewModel = cylinderCardsViewModel
                )
            }

            composable(NavigationRoute.RESULT) {
                val resultViewModel = hiltViewModel<ResultViewModel>()
                ResultScreen.ResultScreen(
                    viewModel = resultViewModel,
                    navController = navController,
                )
            }
            composable(NavigationRoute.ADDING){
                val addingViewModel = hiltViewModel<AddingCylinderViewModel>()
                AddingCylinderScreen(viewModel = addingViewModel)
            }
        }
    }
}
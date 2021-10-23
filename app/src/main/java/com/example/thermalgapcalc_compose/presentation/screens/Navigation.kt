package com.example.thermalgapcalc_compose.presentation.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.thermalgapcalc_compose.NavigationRoute
import com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.EngineSettingsScreen
import com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.EngineValveScreen
import com.example.thermalgapcalc_compose.presentation.screens.resultScreen.ResultScreen
import com.example.thermalgapcalc_compose.presentation.screens.rootScreen.RootScreen

object Navigation {
    @Composable
    fun NavigationComponent(navController: NavHostController) {
        val viewModel = hiltViewModel<EngineSettingsViewModel>()

        NavHost(
            navController = navController,
            startDestination = NavigationRoute.ROOT
        ) {
            composable(NavigationRoute.ENGINE_SETTINGS) {
                EngineSettingsScreen.EngineSettingsScreen(
                    navController = navController,
                    viewModel = viewModel
                )
            }
            composable(NavigationRoute.ROOT){
                RootScreen.RootScreen(navController = navController)
            }

            composable(NavigationRoute.VALVE_SETTINGS) {
                EngineValveScreen.EngineValveScreen(
                    viewModel = viewModel,
                    navController = navController
                )
            }
            composable(NavigationRoute.RESULT) {
                ResultScreen.ResultScreen(
                    viewModel = viewModel,
                    navController = navController
                )
            }
        }
    }
}
package com.example.thermalgapcalc_compose.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.thermalgapcalc_compose.NavigationRoute
import com.example.thermalgapcalc_compose.presentation.screens.SettingsScreen
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
import com.example.thermalgapcalc_compose.presentation.screens.rootScreen.model.RootScreenViewModelViewModel

object Navigation {
    @ExperimentalFoundationApi
    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun NavigationComponent(navController: NavHostController) {

        NavHost(
            navController = navController,
            startDestination = NavigationRoute.ROOT
        ) {
            composable(NavigationRoute.ROOT) {
                val rootScreenViewModelViewModel = hiltViewModel<RootScreenViewModelViewModel>()
                RootScreen.RootScreen(navController = navController, rootScreenViewModelViewModel)
            }

            composable(NavigationRoute.ENGINE_SETTINGS) {
                val engineSettingsViewModel = hiltViewModel<EngineSettingsViewModel>()
                EngineSettingsScreen.EngineSettingsScreen(
                    navController = navController,
                    viewModel = engineSettingsViewModel
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
            composable(NavigationRoute.ADDING) {
                val addingViewModel = hiltViewModel<AddingCylinderViewModel>()
                AddingCylinderScreen(viewModel = addingViewModel)
            }
            composable(NavigationRoute.SETTINGS) {
                SettingsScreen(modifier = Modifier)
            }
        }
    }
}
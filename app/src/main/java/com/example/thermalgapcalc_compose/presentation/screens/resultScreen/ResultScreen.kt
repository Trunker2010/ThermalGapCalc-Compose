package com.example.thermalgapcalc_compose.presentation.screens.resultScreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.thermalgapcalc_compose.presentation.screens.resultScreen.model.ResultState
import com.example.thermalgapcalc_compose.presentation.screens.resultScreen.model.ResultViewModel
import com.example.thermalgapcalc_compose.presentation.screens.resultScreen.view.ResultCardHolder

object ResultScreen {
    @Composable
    fun ResultScreen(
        viewModel: ResultViewModel,
        navController: NavController,
    ) {
        when (val engineViewState = viewModel.resultState.value) {
            is ResultState.Display -> {
                ResultCardHolder(
                    inNormal = engineViewState.engineSettingsConfig.inGapNormal.value.toFloat(),
                    exNormal = engineViewState.engineSettingsConfig.exGapNormal.value.toFloat(),
                    inTolerance = engineViewState.engineSettingsConfig.inGapTolerance.value.toFloat(),
                    exTolerance = engineViewState.engineSettingsConfig.inGapTolerance.value.toFloat(),
                    cylinderStateList = engineViewState.engineSettingsConfig.cylindersList
                )
            }
        }
    }
}
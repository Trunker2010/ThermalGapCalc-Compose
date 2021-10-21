package com.example.thermalgapcalc_compose.presentation.screens.resultScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.thermalgapcalc_compose.presentation.screens.EngineSettingsViewModel
import com.example.thermalgapcalc_compose.presentation.ui.CardResult

object ResultScreen {
    @Composable
    fun ResultScreen(viewModel: EngineSettingsViewModel, navController: NavHostController) {
        ResultCardHolder(viewModel = viewModel)
    }

    @Composable
    fun ResultCardHolder(viewModel: EngineSettingsViewModel) {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
        ) {
            repeat(viewModel.engineViewState.getCylinderQuantity().value.toInt()) { cylinderNumber ->
                val cylinderState = viewModel.cylinderStateList[cylinderNumber]
                CardResult.CardResult(
                    cylinderNumber = cylinderNumber,
                    cylinderState = cylinderState,
                    inNormal = viewModel.engineViewState.getInGapNormal().value.toFloat(),
                    exNormal = viewModel.engineViewState.getExGapNormal().value.toFloat(),
                    inCalcGapDeviation = { inGap -> viewModel.inCalcGapDeviation(inGap) },
                    exCalcGapDeviation = { exGap -> viewModel.exCalcGapDeviation(exGap) },
                    inDeviationStatus = { inDeviation -> viewModel.getInValveStatus(inDeviation) },
                    exDeviationStatus = { exDeviation -> viewModel.getExValveStatus(exDeviation) }
                )
            }
        }
    }

}
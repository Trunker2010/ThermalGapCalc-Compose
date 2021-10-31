package com.example.thermalgapcalc_compose.presentation.screens.resultScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.thermalgapcalc_compose.presentation.screens.resultScreen.model.ResultState
import com.example.thermalgapcalc_compose.presentation.screens.resultScreen.model.ResultViewModel
import com.example.thermalgapcalc_compose.presentation.ui.CardResult

object ResultScreen {
    @Composable
    fun ResultScreen(
        viewModel: ResultViewModel,
        navController: NavHostController,
    ) {
        ResultCardHolder(viewModel = viewModel)
    }

    @Composable
    fun ResultCardHolder(viewModel: ResultViewModel) {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
        ) {
            when (val engineViewState = viewModel.resultState.value) {
                is ResultState.Display -> {
                    repeat(engineViewState.engineSettingsConfig.cylinderQuantity.value.toInt()) { cylinderNumber ->
                        val cylinderState =
                            engineViewState.engineSettingsConfig.cylindersList[cylinderNumber]
                        CardResult.CardResult(
                            cylinderNumber = cylinderNumber,
                            cylinderState = cylinderState,
                            inNormal = engineViewState.engineSettingsConfig.inGapNormal.value.toFloat(),
                            exNormal = engineViewState.engineSettingsConfig.exGapNormal.value.toFloat(),
                            inTolerance = engineViewState.engineSettingsConfig.inGapTolerance.value.toFloat(),
                            exTolerance = engineViewState.engineSettingsConfig.inGapTolerance.value.toFloat(),
                        )
                    }
                }
            }
        }
    }
}
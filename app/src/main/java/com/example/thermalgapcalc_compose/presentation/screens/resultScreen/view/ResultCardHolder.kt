package com.example.thermalgapcalc_compose.presentation.screens.resultScreen.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.example.thermalgapcalc_compose.presentation.screens.resultScreen.model.ResultState
import com.example.thermalgapcalc_compose.presentation.screens.resultScreen.model.ResultViewModel

@Composable
fun ResultCardHolder(viewModel: ResultViewModel) {

    when (val engineViewState = viewModel.resultState.value) {
        is ResultState.Display -> {
            LazyColumn {
                itemsIndexed(engineViewState.engineSettingsConfig.cylindersList,
                    { _, item -> item.hashCode() }) { index, cylinderState ->
                    CardResult(
                        cylinderNumber = index,
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
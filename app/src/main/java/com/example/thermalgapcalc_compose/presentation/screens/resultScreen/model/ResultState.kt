package com.example.thermalgapcalc_compose.presentation.screens.resultScreen.model

import com.example.thermalgapcalc_compose.presentation.screens.data.EngineSettingsConfig

sealed class ResultState {
    data class Display(val engineSettingsConfig: EngineSettingsConfig):ResultState()
}
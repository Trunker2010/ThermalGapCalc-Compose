package com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.ParamsCard

import com.example.thermalgapcalc_compose.presentation.screens.data.EngineSettingsConfig

sealed class ParamsCardState {
    class Display(val engineSettingsConfig: EngineSettingsConfig) : ParamsCardState()
}
package com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.cylinderHolder

import com.example.thermalgapcalc_compose.presentation.screens.data.EngineSettingsConfig

sealed class CylinderHolderState {
    data class Display (val engineSettingsConfig: EngineSettingsConfig) : CylinderHolderState()
}
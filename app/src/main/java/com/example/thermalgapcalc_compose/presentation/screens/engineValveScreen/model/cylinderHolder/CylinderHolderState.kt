package com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.cylinderHolder

import com.example.thermalgapcalc_compose.presentation.data.EngineSettingsConfig

sealed class CylinderHolderState {
    data class Display (val engineSettingsConfig: EngineSettingsConfig) : CylinderHolderState()
}
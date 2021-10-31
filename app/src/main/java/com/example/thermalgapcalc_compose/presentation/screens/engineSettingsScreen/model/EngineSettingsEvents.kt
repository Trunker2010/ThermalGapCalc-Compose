package com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.model

import androidx.compose.runtime.MutableState

sealed class EngineSettingsEvents {

    data class CylinderSizeQuantityChange(val state: MutableState<Float>,val size: Float) : EngineSettingsEvents()
    data class BaseExGapChange(val state: MutableState<String>, val gap: String) : EngineSettingsEvents()
    data class BaseInGapChange(val state: MutableState<String>,val gap: String) : EngineSettingsEvents()
    data class InToleranceChange(val state: MutableState<String>,val inTolerance: String) : EngineSettingsEvents()
    data class ExToleranceChange(val state: MutableState<String>,val exTolerance: String) : EngineSettingsEvents()
    data class InValveSizeChange(val state: MutableState<Int>,val inValveSize: Int) : EngineSettingsEvents()
    data class ExValveSizeChange(val state: MutableState<Int>,val exValveSize: Int) : EngineSettingsEvents()
    object InitialSettings: EngineSettingsEvents()
    object GenerateCylinderList:EngineSettingsEvents()
}
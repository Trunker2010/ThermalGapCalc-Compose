package com.example.thermalgapcalc_compose.presentation.screens.model

sealed class EngineEvent {

    data class CylinderSizeQuantityChange(val size: Float) : EngineEvent()
    data class BaseExGapChange(val gap: String) : EngineEvent()
    data class BaseInGapChange(val gap: String) : EngineEvent()
    data class InToleranceChange(val inTolerance: String): EngineEvent()
    data class ExToleranceChange(val ExTolerance: String): EngineEvent()
    data class InValveSizeChange(val inValveSize: Int): EngineEvent()
    data class ExValveSizeChange(val ExValveSize: Int): EngineEvent()
    object Next : EngineEvent()
}

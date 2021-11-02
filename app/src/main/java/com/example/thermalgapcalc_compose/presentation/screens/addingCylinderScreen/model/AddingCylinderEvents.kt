package com.example.thermalgapcalc_compose.presentation.screens.addingCylinderScreen.model

import androidx.compose.runtime.MutableState

sealed class AddingCylinderEvents {
    data class ExMeasurementGapChange(val state: MutableState<String>, val exGap: String) :
        AddingCylinderEvents()

    data class InMeasurementGapChange(val state: MutableState<String>, val inGap: String) :
        AddingCylinderEvents()

    data class ExMeasurementSpacerChange(
        val state: MutableState<String>,
        val exSpacer: String,
    ) : AddingCylinderEvents()

    data class InMeasurementSpacerChange(val state: MutableState<String>, val inSpacer: String) :
        AddingCylinderEvents()

    object AddCylinderClick : AddingCylinderEvents()
}
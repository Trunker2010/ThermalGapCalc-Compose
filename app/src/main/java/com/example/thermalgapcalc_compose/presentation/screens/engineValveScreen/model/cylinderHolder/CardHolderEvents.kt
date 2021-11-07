package com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.cylinderHolder

import androidx.compose.runtime.MutableState

sealed class CardHolderEvents {

    data class ExMeasurementGapChange(val state: MutableState<String>, val exGap: String) :
        CardHolderEvents()

    data class InMeasurementGapChange(val state: MutableState<String>,val inGap: String) :
        CardHolderEvents()

    data class ExMeasurementSpacerChange(
        val state: MutableState<String>,
        val exSpacer: String,
    ) :
        CardHolderEvents()

    data class InMeasurementSpacerChange(val state: MutableState<String>,val inSpacer: String) :
        CardHolderEvents()

    object SaveEngineMeasurements:CardHolderEvents()
}
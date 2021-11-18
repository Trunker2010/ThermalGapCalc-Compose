package com.example.thermalgapcalc_compose.presentation.data

import androidx.compose.runtime.MutableState

data class CylinderValveMeasurementState(
    var measurementGapState: MutableState<String>,
    var measurementSpacerState: MutableState<String>
)
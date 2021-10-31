package com.example.thermalgapcalc_compose.presentation.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class EngineSettingsConfig(
    var cylinderQuantity: MutableState<Float> = mutableStateOf(0F),
    var inGapNormal: MutableState<String> = mutableStateOf("0.0"),
    var inGapTolerance: MutableState<String> = mutableStateOf("0.0"),
    var exGapNormal: MutableState<String> = mutableStateOf("0.0"),
    var exGapTolerance: MutableState<String> = mutableStateOf("0.0"),
    var inValveQuantity: MutableState<Int> = mutableStateOf(1),
    var exValveQuantity: MutableState<Int> = mutableStateOf(1),
    var cylindersList: List<CylinderState> = mutableListOf(),
)
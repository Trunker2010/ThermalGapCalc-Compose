package com.example.thermalgapcalc_compose.presentation.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class EngineSettingsViewModel : ViewModel() {
    val size = mutableStateOf(0f)
    val inputValveQuantity = mutableStateOf(1)
    val exValveQuantity = mutableStateOf(1)
    val inGapNormal = mutableStateOf("0.0")
    val exGapNormal = mutableStateOf("0.0")
    val inGapTolerance = mutableStateOf("0.0")
    val exGapTolerance = mutableStateOf("0.0")

}
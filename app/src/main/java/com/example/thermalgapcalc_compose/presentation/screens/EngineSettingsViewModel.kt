package com.example.thermalgapcalc_compose.presentation.screens

import androidx.lifecycle.ViewModel
import com.example.thermalgapcalc_compose.presentation.EngineViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EngineSettingsViewModel @Inject constructor(
    val engineViewState: EngineViewState
) : ViewModel() {



//    var size = mutableStateOf(0f)
//    val inputValveQuantity = mutableStateOf(1)
//    val exValveQuantity = mutableStateOf(1)
//    val inGapNormal = mutableStateOf("0.0")
//    val exGapNormal = mutableStateOf("0.0")
//    val inGapTolerance = mutableStateOf("0.0")
//    val exGapTolerance = mutableStateOf("0.0")

}
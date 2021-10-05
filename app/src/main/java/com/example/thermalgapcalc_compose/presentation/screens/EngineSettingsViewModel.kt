package com.example.thermalgapcalc_compose.presentation.screens

import androidx.lifecycle.ViewModel
import com.example.thermalgapcalc_compose.presentation.CylinderState
import com.example.thermalgapcalc_compose.presentation.EngineViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EngineSettingsViewModel @Inject constructor(
    val engineViewState: EngineViewState
) : ViewModel() {
    lateinit var cylinderStateList: List<CylinderState>

    fun initCylindersState() {
        cylinderStateList = List(engineViewState.getCylinderQuantity().value.toInt()) {
            CylinderState(
                engineViewState.getInValveQuantity().value,
                engineViewState.getExValveQuantity().value
            )
        }
    }
}
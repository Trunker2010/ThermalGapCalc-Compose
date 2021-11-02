package com.example.thermalgapcalc_compose.presentation.screens.addingCylinderScreen.model

import com.example.thermalgapcalc_compose.presentation.data.CylinderState

sealed class AddingCylinderState {
    data class Display(val cylinderState: CylinderState) : AddingCylinderState()
}
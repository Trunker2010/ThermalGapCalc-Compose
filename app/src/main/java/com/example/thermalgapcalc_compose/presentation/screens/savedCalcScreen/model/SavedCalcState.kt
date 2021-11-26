package com.example.thermalgapcalc_compose.presentation.screens.savedCalcScreen.model

import com.example.thermalgapcalc_compose.domain.model.SaveCylindersMeasurements

sealed class SavedCalcState {
    object Init : SavedCalcState()
    object Loading : SavedCalcState()
    object Empty : SavedCalcState()
    class Display(val measurementsList: List<SaveCylindersMeasurements>) : SavedCalcState()
}
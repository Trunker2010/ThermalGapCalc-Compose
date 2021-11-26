package com.example.thermalgapcalc_compose.presentation.screens.savedCalcScreen.model

sealed class SavedEvent {
    class LoadMeasurementList(val id: String) : SavedEvent()
}
package com.example.thermalgapcalc_compose.presentation.screens.savedDetailsScreen.model

sealed class SavedDetailsScreenEvent {
    class LoadMeasurements(val id:String) : SavedDetailsScreenEvent()
}
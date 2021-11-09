package com.example.thermalgapcalc_compose.presentation.screens.rootScreen.model

sealed class RootScreenEvent {
    object LoadMeasurementList : RootScreenEvent()
    class ShowDetails(id: String) : RootScreenEvent()
}
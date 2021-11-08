package com.example.thermalgapcalc_compose.presentation.screens.rootScreen.model

import com.example.thermalgapcalc_compose.domain.model.EngineMeasurementModel

sealed class RootScreenState{
    object Init:RootScreenState()
    object Loading:RootScreenState()
    object Empty:RootScreenState()
    class Display(val measurementsList: List<EngineMeasurementModel>):RootScreenState()
}
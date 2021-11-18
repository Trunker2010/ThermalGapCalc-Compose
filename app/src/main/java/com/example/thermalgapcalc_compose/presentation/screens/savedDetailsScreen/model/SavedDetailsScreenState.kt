package com.example.thermalgapcalc_compose.presentation.screens.savedDetailsScreen.model

import com.example.thermalgapcalc_compose.presentation.data.CylinderState

sealed class SavedDetailsScreenState(){
    object Init: SavedDetailsScreenState()
    object Loading: SavedDetailsScreenState()
    object Empty: SavedDetailsScreenState()
    class Display(val measurementsList: List<CylinderState>): SavedDetailsScreenState()
}

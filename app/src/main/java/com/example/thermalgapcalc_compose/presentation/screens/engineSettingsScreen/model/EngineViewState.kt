package com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.model

import com.example.thermalgapcalc_compose.presentation.screens.data.EngineSettingsConfig

sealed class EngineViewState {
    data class ViewStateInitial(
        val engineSettingsConfig: EngineSettingsConfig,
    ) : EngineViewState()
}
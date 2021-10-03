package com.example.thermalgapcalc_compose.presentation.screens

import androidx.lifecycle.ViewModel
import com.example.thermalgapcalc_compose.presentation.EngineViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EngineSettingsViewModel @Inject constructor(
    val engineViewState: EngineViewState
) : ViewModel() {
}
package com.example.thermalgapcalc_compose.presentation.screens.resultScreen.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thermalgapcalc_compose.presentation.screens.data.EngineSettingsConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    val engineSettingsConfig: EngineSettingsConfig,
) : ViewModel(
) {
    private val _resultState: MutableLiveData<ResultState> =
        MutableLiveData(ResultState.Display(engineSettingsConfig = engineSettingsConfig))
    val resultState = _resultState
}
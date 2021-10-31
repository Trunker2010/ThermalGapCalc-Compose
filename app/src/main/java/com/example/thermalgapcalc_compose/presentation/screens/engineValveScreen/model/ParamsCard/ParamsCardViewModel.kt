package com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.ParamsCard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thermalgapcalc_compose.presentation.screens.data.EngineSettingsConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ParamsCardViewModel @Inject constructor(
    engineSettingsConfig: EngineSettingsConfig,
) : ViewModel() {
    private val _cardParamsState: MutableLiveData<ParamsCardState> =
        MutableLiveData(ParamsCardState.Display(engineSettingsConfig))
    val cardParamsState = _cardParamsState
}
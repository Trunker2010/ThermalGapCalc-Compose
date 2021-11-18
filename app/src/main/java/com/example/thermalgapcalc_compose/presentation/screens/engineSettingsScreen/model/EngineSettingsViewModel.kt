package com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thermalgapcalc_compose.base.EventHandler
import com.example.thermalgapcalc_compose.presentation.data.EngineSettingsConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EngineSettingsViewModel @Inject constructor(
    engineSettingsConfig: EngineSettingsConfig,
) : ViewModel(), EventHandler<EngineSettingsEvents> {
    private val _engineViewState: MutableLiveData<EngineViewState> =
        MutableLiveData(EngineViewState.ViewStateInitial(engineSettingsConfig))
    val engineViewState: LiveData<EngineViewState> = _engineViewState

    override fun obtainEvent(event: EngineSettingsEvents) {
        when (val currentViewState = _engineViewState.value) {
            is EngineViewState.ViewStateInitial -> {
                reduce(event, currentViewState)
            }
        }
    }

    private fun reduce(
        settingsEvents: EngineSettingsEvents,
        engineViewState: EngineViewState.ViewStateInitial,
    ) {
        when (settingsEvents) {
            is EngineSettingsEvents.InToleranceChange -> {

                if (settingsEvents.inTolerance.isEmpty()) {
                    settingsEvents.state.value = "0"
                }
                else if (settingsEvents.inTolerance.startsWith(",") || settingsEvents.inTolerance.startsWith(".")
                ) {
                    settingsEvents.state.value = "0,"
                }
                else if (settingsEvents.state.value == "0" && settingsEvents.inTolerance.startsWith("00")
                ) {
                    settingsEvents.state.value = "0"
                }
                else if (settingsEvents.state.value.contains(",")||settingsEvents.state.value.contains(".")){

                }
                else {
                    settingsEvents.state.value = settingsEvents.inTolerance
                }


            }
            is EngineSettingsEvents.BaseInGapChange -> {
                settingsEvents.state.value = settingsEvents.gap
            }
            is EngineSettingsEvents.BaseExGapChange -> {
                settingsEvents.state.value = settingsEvents.gap
            }

            is EngineSettingsEvents.ExToleranceChange -> {
                settingsEvents.state.value = settingsEvents.exTolerance
            }
            is EngineSettingsEvents.ExValveSizeChange -> {
                settingsEvents.state.value = settingsEvents.exValveSize
            }
            is EngineSettingsEvents.InValveSizeChange -> {
                settingsEvents.state.value = settingsEvents.inValveSize
            }
            is EngineSettingsEvents.NextClicked -> {
                engineViewState.engineSettingsConfig.cylindersList.clear()
            }
        }
    }
}
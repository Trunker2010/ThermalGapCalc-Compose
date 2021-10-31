package com.example.thermalgapcalc_compose.presentation.screens.engineSettingsScreen.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thermalgapcalc_compose.base.EventHandler
import com.example.thermalgapcalc_compose.presentation.screens.data.CylinderState
import com.example.thermalgapcalc_compose.presentation.screens.data.EngineSettingsConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EngineSettingsViewModel @Inject constructor(
    engineSettingsConfig: EngineSettingsConfig,
) : ViewModel(), EventHandler<EngineSettingsEvents> {
    private val _engineViewState: MutableLiveData<EngineViewState> =
        MutableLiveData(EngineViewState.ViewStateInitial(engineSettingsConfig))
    val engineViewState: LiveData<EngineViewState> = _engineViewState

    override fun obtainEvent(settingsEvents: EngineSettingsEvents) {
        when (val currentViewState = _engineViewState.value) {
            is EngineViewState.ViewStateInitial -> {
                reduce(settingsEvents, currentViewState)
            }
        }
    }

    private fun reduce(
        settingsEvents: EngineSettingsEvents,
        engineViewState: EngineViewState.ViewStateInitial,
    ) {
        when (settingsEvents) {
            is EngineSettingsEvents.CylinderSizeQuantityChange -> {
                settingsEvents.state.value = settingsEvents.size
            }
            is EngineSettingsEvents.InToleranceChange -> {
                settingsEvents.state.value = settingsEvents.inTolerance
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
            is EngineSettingsEvents.GenerateCylinderList -> {
                engineViewState.apply {
                    viewModelScope.launch {
                        engineSettingsConfig.cylindersList =
                            generateCylindersState(engineSettingsConfig.cylinderQuantity.value.toInt(),
                                engineSettingsConfig.inValveQuantity.value,
                                engineSettingsConfig.exValveQuantity.value)
                    }
                }
            }
        }
    }

    private fun generateCylindersState(
        size: Int,
        inValveQuantity: Int,
        exValveQuantity: Int,
    ): MutableList<CylinderState> {
        return MutableList(size) {
            CylinderState(
                inValveQuantity,
                exValveQuantity
            )
        }
    }
}
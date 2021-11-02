package com.example.thermalgapcalc_compose.presentation.screens.addingCylinderScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thermalgapcalc_compose.base.EventHandler
import com.example.thermalgapcalc_compose.presentation.data.CylinderState
import com.example.thermalgapcalc_compose.presentation.data.EngineSettingsConfig
import com.example.thermalgapcalc_compose.presentation.screens.addingCylinderScreen.model.AddingCylinderEvents
import com.example.thermalgapcalc_compose.presentation.screens.addingCylinderScreen.model.AddingCylinderState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddingCylinderViewModel @Inject constructor(
    val engineSettingsConfig: EngineSettingsConfig,
) : ViewModel(), EventHandler<AddingCylinderEvents> {

    private val _addingCylinderState =
        MutableLiveData<AddingCylinderState>(AddingCylinderState.Display(cylinderState = CylinderState(engineSettingsConfig.inValveQuantity.value,engineSettingsConfig.exValveQuantity.value)))
    val addingCylinderState: LiveData<AddingCylinderState> = _addingCylinderState
    override fun obtainEvent(event: AddingCylinderEvents) {
        when (val state = _addingCylinderState.value) {
            is AddingCylinderState.Display -> {
                reduce(state = state, event)
            }
        }
    }

    private fun reduce(state: AddingCylinderState.Display, event: AddingCylinderEvents) {
        when (event) {
            is AddingCylinderEvents.ExMeasurementSpacerChange -> {
                event.state.value = event.exSpacer
            }
            is AddingCylinderEvents.ExMeasurementGapChange -> {
                event.state.value = event.exGap
            }
            is AddingCylinderEvents.InMeasurementSpacerChange -> {
                event.state.value = event.inSpacer
            }
            is AddingCylinderEvents.InMeasurementGapChange -> {
                event.state.value = event.inGap
            }
            is AddingCylinderEvents.AddCylinderClick,
            -> {
                engineSettingsConfig.cylindersList.add(state.cylinderState)

            }
        }
    }
}
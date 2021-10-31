package com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.cylinderHolder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thermalgapcalc_compose.base.EventHandler
import com.example.thermalgapcalc_compose.presentation.screens.data.EngineSettingsConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CylinderCardsViewModel @Inject constructor(engineSettingsConfig: EngineSettingsConfig) :
    ViewModel(), EventHandler<CardHolderEvents> {
    private val _cardHolderViewState: MutableLiveData<CylinderHolderState> =
        MutableLiveData(CylinderHolderState.Display(engineSettingsConfig))
    val cardHolderViewState: LiveData<CylinderHolderState> = _cardHolderViewState

    override fun obtainEvent(event: CardHolderEvents) {
        when (val state = _cardHolderViewState.value) {
            is CylinderHolderState.Display -> {
                reduce(state, event)
            }
        }
    }

    private fun reduce(state: CylinderHolderState.Display, event: CardHolderEvents) {
        when (event) {
            is CardHolderEvents.ExMeasurementGapChange -> event.state.value = event.exGap
            is CardHolderEvents.ExMeasurementSpacerChange -> event.state.value = event.exSpacer
            is CardHolderEvents.InMeasurementGapChange -> event.state.value = event.inGap
            is CardHolderEvents.InMeasurementSpacerChange -> event.state.value = event.inSpacer
        }
    }
}
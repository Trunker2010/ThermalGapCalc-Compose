package com.example.thermalgapcalc_compose.presentation.screens.engineValveScreen.model.cylinderHolder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thermalgapcalc_compose.base.EventHandler
import com.example.thermalgapcalc_compose.domain.model.SaveEngineMeasurementParam
import com.example.thermalgapcalc_compose.domain.useCas.SaveEngineMeasurementUseCase
import com.example.thermalgapcalc_compose.presentation.data.EngineSettingsConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CylinderCardsViewModel @Inject constructor(
    engineSettingsConfig: EngineSettingsConfig,
    private val saveEngineMeasurementUseCase: SaveEngineMeasurementUseCase,
) :
    ViewModel(), EventHandler<CardHolderEvents> {
    private val _cardHolderViewState: MutableLiveData<CylinderHolderState> =
        MutableLiveData(CylinderHolderState.Display(engineSettingsConfig))
    val cardHolderViewState: LiveData<CylinderHolderState> = _cardHolderViewState

    override fun obtainEvent(event: CardHolderEvents) {
        when (val state = _cardHolderViewState.value) {
            is CylinderHolderState.Display -> {
                reduce(state, event)
            }
            null -> TODO()
        }
    }

    private fun reduce(state: CylinderHolderState.Display, event: CardHolderEvents) {
        when (event) {
            is CardHolderEvents.ExMeasurementGapChange -> event.state.value = event.exGap
            is CardHolderEvents.ExMeasurementSpacerChange -> event.state.value = event.exSpacer
            is CardHolderEvents.InMeasurementGapChange -> event.state.value = event.inGap
            is CardHolderEvents.InMeasurementSpacerChange -> event.state.value = event.inSpacer
            is CardHolderEvents.SaveEngineMeasurements -> {
                state.engineSettingsConfig.also {
                    val saveEngineMeasurementParam = SaveEngineMeasurementParam(
                        date = System.currentTimeMillis(),
                        inGapNormal = it.inGapNormal.value,
                        inGapTolerance = it.inGapTolerance.value,
                        exGapNormal = it.exGapNormal.value,
                        exGapTolerance = it.exGapTolerance.value,
                        cylindersList = it.cylindersList,
                        inValveQuantity = it.inValveQuantity.value,
                        exValveQuantity = it.exValveQuantity.value,
                    )
                    saveMeasurements(saveEngineMeasurementParam)
                }

            }
        }
    }

    private fun saveMeasurements(saveEngineMeasurementParam: SaveEngineMeasurementParam) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                saveEngineMeasurementUseCase.execute(saveEngineMeasurementParam)
            }
        }
    }
}
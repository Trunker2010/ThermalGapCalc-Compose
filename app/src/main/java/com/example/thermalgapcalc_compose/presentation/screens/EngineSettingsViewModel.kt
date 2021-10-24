package com.example.thermalgapcalc_compose.presentation.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thermalgapcalc_compose.base.EventHandler
import com.example.thermalgapcalc_compose.presentation.CylinderState
import com.example.thermalgapcalc_compose.presentation.EngineViewState
import com.example.thermalgapcalc_compose.presentation.screens.model.EngineEvent
import com.example.thermalgapcalc_compose.presentation.utils.CalcUtils.calcGapDeviation
import com.example.thermalgapcalc_compose.presentation.utils.CalcUtils.getDeviationStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EngineSettingsViewModel @Inject constructor(
) : ViewModel(), EventHandler<EngineEvent> {

    private val _engineViewState: MutableLiveData<EngineViewState> =
        MutableLiveData(EngineViewState.ViewStateInitial())
    val engineViewState: LiveData<EngineViewState> = _engineViewState

    override fun obtainEvent(event: EngineEvent) {
        when (val currentViewState = _engineViewState.value) {
            is EngineViewState.ViewStateInitial -> {
                reduce(event, currentViewState)
            }
        }
    }

    private fun reduce(event: EngineEvent, engineViewState: EngineViewState.ViewStateInitial) {
        when (event) {
            is EngineEvent.CylinderSizeQuantityChange -> _engineViewState.postValue(engineViewState.copy(
                cylinderQuantity = event.size))
            is EngineEvent.InToleranceChange -> _engineViewState.postValue(engineViewState.copy(
                inGapTolerance = event.inTolerance))
            is EngineEvent.BaseInGapChange -> _engineViewState.postValue(engineViewState.copy(
                inGapNormal = event.gap))
            is EngineEvent.BaseExGapChange -> _engineViewState.postValue(engineViewState.copy(
                exGapNormal = event.gap))
            is EngineEvent.ExToleranceChange -> _engineViewState.postValue(engineViewState.copy(
                exGapTolerance = event.ExTolerance
            ))
            is EngineEvent.ExValveSizeChange -> _engineViewState.postValue((engineViewState.copy(
                exValveQuantity = event.ExValveSize)))
            is EngineEvent.InValveSizeChange -> _engineViewState.postValue((engineViewState.copy(
                inValveQuantity = event.inValveSize)))
        }
    }

//    fun initCylindersState() {
//        cylinderStateList = List(engineViewState.getCylinderQuantity().value.toInt()) {
//            CylinderState(
//                engineViewState.getInValveQuantity().value,
//                engineViewState.getExValveQuantity().value
//            )
//        }
//    }
//
//    fun getInValveStatus(deviation: Float): String {
//        return getDeviationStatus(engineViewState.getInGapTolerance().value.toFloat(), deviation)
//    }
//
//    fun getExValveStatus(deviation: Float): String {
//        return getDeviationStatus(engineViewState.getExGapTolerance().value.toFloat(), deviation)
//    }
//
//    fun inCalcGapDeviation(gap: Float): Float {
//        return calcGapDeviation(engineViewState.getInGapNormal().value.toFloat(), gap = gap)
//    }
//
//    fun exCalcGapDeviation(gap: Float): Float {
//        return calcGapDeviation(engineViewState.getExGapNormal().value.toFloat(), gap = gap)
//    }


}
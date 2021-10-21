package com.example.thermalgapcalc_compose.presentation.screens

import androidx.lifecycle.ViewModel
import com.example.thermalgapcalc_compose.presentation.CylinderState
import com.example.thermalgapcalc_compose.presentation.EngineViewState
import com.example.thermalgapcalc_compose.presentation.utils.CalcUtils.calcGapDeviation
import com.example.thermalgapcalc_compose.presentation.utils.CalcUtils.getDeviationStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EngineSettingsViewModel @Inject constructor(
    val engineViewState: EngineViewState
) : ViewModel() {
    lateinit var cylinderStateList: List<CylinderState>

    fun initCylindersState() {
        cylinderStateList = List(engineViewState.getCylinderQuantity().value.toInt()) {
            CylinderState(
                engineViewState.getInValveQuantity().value,
                engineViewState.getExValveQuantity().value
            )
        }
    }

    fun getInValveStatus(deviation: Float): String {
        return getDeviationStatus(engineViewState.getInGapTolerance().value.toFloat(), deviation)
    }

    fun getExValveStatus(deviation: Float): String {
        return getDeviationStatus(engineViewState.getExGapTolerance().value.toFloat(), deviation)
    }

    fun inCalcGapDeviation(gap: Float): Float {
        return calcGapDeviation(engineViewState.getInGapNormal().value.toFloat(), gap = gap)
    }

    fun exCalcGapDeviation(gap: Float): Float {
        return calcGapDeviation(engineViewState.getExGapNormal().value.toFloat(), gap = gap)
    }
}
package com.example.thermalgapcalc_compose.presentation.data

import androidx.compose.runtime.mutableStateOf
import com.example.thermalgapcalc_compose.domain.model.SaveCylinderValveMeasurementState

data class CylinderState(var inValveSize: Int, var exValveSize: Int) {
    var inValveList = mutableListOf<CylinderValveMeasurementState>()
    var exValveList = mutableListOf<CylinderValveMeasurementState>()

    init {
        do {
            inValveList.add(CylinderValveMeasurementState(mutableStateOf("0"),mutableStateOf("0")))
        } while (inValveSize != inValveList.size)
        do {
            exValveList.add(CylinderValveMeasurementState(mutableStateOf("0"),mutableStateOf("0")))
        } while (exValveSize != exValveList.size)
    }
}

fun MutableList<CylinderValveMeasurementState>.toParam(): MutableList<SaveCylinderValveMeasurementState> {
    val list = mutableListOf<SaveCylinderValveMeasurementState>()
    this.forEach {
        list.add(SaveCylinderValveMeasurementState(it.measurementGapState.value,
            it.measurementSpacerState.value))
    }
    return list
}
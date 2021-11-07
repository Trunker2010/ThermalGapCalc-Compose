package com.example.thermalgapcalc_compose.presentation.data

import com.example.thermalgapcalc_compose.domain.model.SaveCylinderValveMeasurementState

data class CylinderState(var inValveSize: Int, var exValveSize: Int) {
    val inValveList = mutableListOf<CylinderValveMeasurementState>()
    val exValveList = mutableListOf<CylinderValveMeasurementState>()

    init {
        do {
            inValveList.add(CylinderValveMeasurementState())
        } while (inValveSize != inValveList.size)
        do {
            exValveList.add(CylinderValveMeasurementState())
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
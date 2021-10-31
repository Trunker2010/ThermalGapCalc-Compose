package com.example.thermalgapcalc_compose.presentation.screens.data


class CylinderState(inValveSize: Int, exValveSize: Int) {
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
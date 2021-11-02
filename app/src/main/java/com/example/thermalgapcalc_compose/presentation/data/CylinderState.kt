package com.example.thermalgapcalc_compose.presentation.data

data class CylinderState(var inValveSize: Int, var exValveSize: Int) : Cloneable {
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
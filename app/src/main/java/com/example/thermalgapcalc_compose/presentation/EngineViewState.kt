package com.example.thermalgapcalc_compose.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class CylinderValveMeasurementState {
    val measurementGapState: MutableState<String> = mutableStateOf("0.0")
    val measurementWasherState: MutableState<String> = mutableStateOf("0.0")
    val resultedWasherState: MutableState<String> = mutableStateOf("000")
}

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

data class EngineViewState(
    private val cylinderQuantity: MutableState<Float> = mutableStateOf(0f),
    private val inGapNormal: MutableState<String> = mutableStateOf("0.0"),
    private val inGapTolerance: MutableState<String> = mutableStateOf("0.0"),
    private val exGapNormal: MutableState<String> = mutableStateOf("0.0"),
    private val exGapTolerance: MutableState<String> = mutableStateOf("0.0"),
    private val inValveQuantity: MutableState<Int> = mutableStateOf(1),
    private val exValveQuantity: MutableState<Int> = mutableStateOf(1),
) {

    fun getCylinderQuantity() = cylinderQuantity
    fun setCylinderQuantity(cylinderQuantity: Float) {
        this.cylinderQuantity.value = cylinderQuantity
    }

    fun getInGapNormal() = inGapNormal
    fun setInGapNormal(inGapNormal: String) {
        this.inGapNormal.value = inGapNormal
    }

    fun getInGapTolerance() = inGapTolerance
    fun setInGapTolerance(inGapTolerance: String) {
        this.inGapTolerance.value = inGapTolerance
    }

    fun getExGapNormal() = exGapNormal
    fun setExGapNormal(exGapNormal: String) {
        this.exGapNormal.value = exGapNormal
    }

    fun getExGapTolerance() = exGapTolerance
    fun setExGapTolerance(exGapTolerance: String) {
        this.exGapTolerance.value = exGapTolerance
    }

    fun getExValveQuantity() = exValveQuantity
    fun setExValveQuantity(exValveQuantity: Int) {
        this.exValveQuantity.value = exValveQuantity
    }

    fun getInValveQuantity() = inValveQuantity
    fun setInValveQuantity(inValveQuantity: Int) {
        this.inValveQuantity.value = inValveQuantity
    }
}
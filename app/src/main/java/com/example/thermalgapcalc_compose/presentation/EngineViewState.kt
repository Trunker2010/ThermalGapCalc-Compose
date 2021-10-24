package com.example.thermalgapcalc_compose.presentation

class CylinderValveMeasurementState {
    val measurementGapState: String = "0.0"
    val measurementSpacerState: String = "0.0"
    val resultedSpacerState: String = "000"
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

sealed class EngineViewState(

) {
    data class ViewStateInitial(
        var cylinderQuantity: Float = 0f,
        var inGapNormal: String = "0.0",
        var inGapTolerance: String = "0.0",
        var exGapNormal: String = "0.0",
        var exGapTolerance: String = "0.0",
        var inValveQuantity: Int = 1,
        var exValveQuantity: Int = 1,
        val cylinderState: CylinderState = CylinderState(1, 1),
    ) : EngineViewState()


//
//    fun getCylinderQuantity() = cylinderQuantity
//    fun setCylinderQuantity(cylinderQuantity: Float) {
//        this.cylinderQuantity = cylinderQuantity
//    }
//
//    fun getInGapNormal() = inGapNormal
//    fun setInGapNormal(inGapNormal: String) {
//        this.inGapNormal = inGapNormal
//    }
//
//    fun getInGapTolerance() = inGapTolerance
//    fun setInGapTolerance(inGapTolerance: String) {
//        this.inGapTolerance = inGapTolerance
//    }
//
//    fun getExGapNormal() = exGapNormal
//    fun setExGapNormal(exGapNormal: String) {
//        this.exGapNormal = exGapNormal
//    }
//
//    fun getExGapTolerance() = exGapTolerance
//    fun setExGapTolerance(exGapTolerance: String) {
//        this.exGapTolerance = exGapTolerance
//    }
//
//    fun getExValveQuantity() = exValveQuantity
//    fun setExValveQuantity(exValveQuantity: Int) {
//        this.exValveQuantity = exValveQuantity
//    }
//
//    fun getInValveQuantity() = inValveQuantity
//    fun setInValveQuantity(inValveQuantity: Int) {
//        this.inValveQuantity = inValveQuantity
//    }
}
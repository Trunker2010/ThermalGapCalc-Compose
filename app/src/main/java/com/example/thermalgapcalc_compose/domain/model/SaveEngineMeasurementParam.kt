package com.example.thermalgapcalc_compose.domain.model

import androidx.compose.runtime.mutableStateOf
import com.example.thermalgapcalc_compose.data.db.entity.SettingsEngineParamsEntity
import com.example.thermalgapcalc_compose.presentation.data.CylinderState
import com.example.thermalgapcalc_compose.presentation.data.CylinderValveMeasurementState
import com.example.thermalgapcalc_compose.presentation.data.toParam
import com.google.gson.Gson
import java.util.*

data class SaveEngineMeasurementParam(
    val date: Long,
    val inGapNormal: String,
    val inGapTolerance: String,
    val exGapNormal: String,
    val exGapTolerance: String,
    val inValveQuantity: Int,
    val exValveQuantity: Int,
    val cylindersList: MutableList<CylinderState>,
)

data class SaveCylindersMeasurements(
    val inValveList: MutableList<SaveCylinderValveMeasurementState>,
    val exValveList: MutableList<SaveCylinderValveMeasurementState>,
)

data class SaveCylinderValveMeasurementState(
    val measurementGapState: String,
    val measurementSpacerState: String,
)

fun SaveCylinderValveMeasurementState.toCylinderValveMeasurementState(): CylinderValveMeasurementState {
    val cylinderValveMeasurementState = CylinderValveMeasurementState()
    cylinderValveMeasurementState.measurementGapState = mutableStateOf(this.measurementGapState)
    cylinderValveMeasurementState.measurementSpacerState =
        mutableStateOf(this.measurementSpacerState)
    return cylinderValveMeasurementState
}

fun SaveEngineMeasurementParam.toMeasurementEngineEntity(): SettingsEngineParamsEntity {

    return SettingsEngineParamsEntity(
        id = UUID.randomUUID().toString(),
        date = this.date,
        inGapNormal = this.inGapNormal,
        inGapTolerance = this.inGapTolerance,
        exGapNormal = this.exGapNormal,
        exGapTolerance = this.exGapTolerance,
        inValveQuantity = this.inValveQuantity,
        exValveQuantity = this.exValveQuantity,
        IdCylindersListJson = UUID.randomUUID().toString()
    )
}

fun SaveEngineMeasurementParam.getGsonEngineList(): String {
    val gson = Gson()
    val cylindersMeasurementsList: MutableList<SaveCylindersMeasurements> = mutableListOf()

    this.cylindersList.forEach {
        val cylindersSaveMeasurements =
            SaveCylindersMeasurements(it.inValveList.toParam(), it.exValveList.toParam())
        cylindersMeasurementsList.add(cylindersSaveMeasurements)
    }
    return gson.toJson(cylindersMeasurementsList)
}
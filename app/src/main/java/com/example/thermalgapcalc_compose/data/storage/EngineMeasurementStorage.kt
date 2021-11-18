package com.example.thermalgapcalc_compose.data.storage

import com.example.thermalgapcalc_compose.domain.model.EngineMeasurementModel
import com.example.thermalgapcalc_compose.domain.model.SaveCylindersMeasurements
import com.example.thermalgapcalc_compose.domain.model.SaveEngineMeasurementParam

interface EngineMeasurementStorage {
    fun getSettingsEngineList(): List<EngineMeasurementModel>
    fun save(saveEngineMeasurementParam: SaveEngineMeasurementParam)
    fun getMeasurementList(id: String): List<SaveCylindersMeasurements>
}
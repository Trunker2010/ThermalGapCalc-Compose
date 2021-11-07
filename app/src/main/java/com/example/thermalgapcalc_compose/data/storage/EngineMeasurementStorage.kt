package com.example.thermalgapcalc_compose.data.storage

import com.example.thermalgapcalc_compose.domain.model.EngineMeasurementModel
import com.example.thermalgapcalc_compose.domain.model.SaveEngineMeasurementParam

interface EngineMeasurementStorage {
    fun getList(): List<EngineMeasurementModel>
    fun save(saveEngineMeasurementParam: SaveEngineMeasurementParam)
}
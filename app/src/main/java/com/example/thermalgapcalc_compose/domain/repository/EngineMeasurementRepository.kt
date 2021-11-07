package com.example.thermalgapcalc_compose.domain.repository

import com.example.thermalgapcalc_compose.domain.model.EngineMeasurementModel
import com.example.thermalgapcalc_compose.domain.model.SaveEngineMeasurementParam

interface EngineMeasurementRepository {
    suspend fun getEngineMeasurementList(): List<EngineMeasurementModel>
    suspend fun saveEngineMeasurement(saveEngineMeasurementParam: SaveEngineMeasurementParam)
}
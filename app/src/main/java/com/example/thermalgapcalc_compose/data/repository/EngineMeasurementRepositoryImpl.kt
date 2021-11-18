package com.example.thermalgapcalc_compose.data.repository

import com.example.thermalgapcalc_compose.data.storage.LocalEngineMeasurementStorage
import com.example.thermalgapcalc_compose.domain.repository.EngineMeasurementRepository
import com.example.thermalgapcalc_compose.domain.model.EngineMeasurementModel
import com.example.thermalgapcalc_compose.domain.model.SaveCylindersMeasurements
import com.example.thermalgapcalc_compose.domain.model.SaveEngineMeasurementParam

class EngineMeasurementRepositoryImpl(private val localEngineMeasurementStorage: LocalEngineMeasurementStorage) :
    EngineMeasurementRepository {
    override suspend fun getEngineMeasurementList(): List<EngineMeasurementModel> {
        return localEngineMeasurementStorage.getSettingsEngineList()
    }

    override suspend fun saveEngineMeasurement(saveEngineMeasurementParam: SaveEngineMeasurementParam) {
        localEngineMeasurementStorage.save(saveEngineMeasurementParam = saveEngineMeasurementParam)
    }

    override suspend fun getMeasurementDetails(id: String): List<SaveCylindersMeasurements> {
        return localEngineMeasurementStorage.getMeasurementList(id)
    }
}
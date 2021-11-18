package com.example.thermalgapcalc_compose.domain.useCas

import com.example.thermalgapcalc_compose.data.repository.EngineMeasurementRepositoryImpl
import com.example.thermalgapcalc_compose.domain.model.SaveCylindersMeasurements

class GetMeasurementDetailsListUseCase(private val engineMeasurementRepositoryImpl: EngineMeasurementRepositoryImpl) {
    suspend fun execute(id: String): List<SaveCylindersMeasurements> {
        return engineMeasurementRepositoryImpl.getMeasurementDetails(id)
    }
}
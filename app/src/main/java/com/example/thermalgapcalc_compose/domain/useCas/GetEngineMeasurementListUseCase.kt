package com.example.thermalgapcalc_compose.domain.useCas

import com.example.thermalgapcalc_compose.domain.repository.EngineMeasurementRepository
import com.example.thermalgapcalc_compose.domain.model.EngineMeasurementModel

class GetEngineMeasurementListUseCase(private val engineMeasurementRepository: EngineMeasurementRepository) {
   suspend fun execute(): List<EngineMeasurementModel> {
        return engineMeasurementRepository.getEngineMeasurementList()
    }
}
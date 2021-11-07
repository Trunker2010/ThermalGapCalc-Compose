package com.example.thermalgapcalc_compose.domain.useCas

import com.example.thermalgapcalc_compose.domain.repository.EngineMeasurementRepository
import com.example.thermalgapcalc_compose.domain.model.SaveEngineMeasurementParam

class SaveEngineMeasurementUseCase(private val engineMeasurementRepository: EngineMeasurementRepository) {
  suspend  fun execute(engineMeasurement: SaveEngineMeasurementParam) {
        engineMeasurementRepository.saveEngineMeasurement(engineMeasurement)
    }
}
package com.example.thermalgapcalc_compose.domain.model

data class EngineMeasurementModel(
    val id :String,
    val date: Long,
    val inGapNormal: String,
    val inGapTolerance: String,
    val exGapNormal: String,
    val exGapTolerance: String,
    val IdCylindersList: String
)
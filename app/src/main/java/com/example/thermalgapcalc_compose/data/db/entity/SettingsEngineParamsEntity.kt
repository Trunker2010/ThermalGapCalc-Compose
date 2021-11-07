package com.example.thermalgapcalc_compose.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SettingsEngineParamsEntity(
    @PrimaryKey
    val id: String,
    val date: Long?,
    val inGapNormal: String?,
    val inGapTolerance: String?,
    val exGapNormal: String?,
    val exGapTolerance: String?,
    val cylindersListJson: String,
)
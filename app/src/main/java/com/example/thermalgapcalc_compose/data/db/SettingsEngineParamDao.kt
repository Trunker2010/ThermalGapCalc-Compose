package com.example.thermalgapcalc_compose.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.thermalgapcalc_compose.data.db.entity.SettingsEngineParamsEntity

@Dao
interface SettingsEngineParamDao {
    @Query("SELECT * FROM SettingsEngineParamsEntity")
    fun getAll(): List<SettingsEngineParamsEntity>

    @Insert
    fun save(settingsEngineParamsEntity: SettingsEngineParamsEntity)
}